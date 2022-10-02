package transaction.analyzer;

import transaction.dto.BankTransactionStatement;
import transaction.parser.BankTransactionStatementParser;
import transaction.processor.BankTransactionCSVProcessor;
import transaction.processor.BankTransactionFilter;
import transaction.reader.BankTransactionCSVReader;
import transaction.reader.BankTransactionFileReader;
import transaction.reporter.HtmlReporter;
import transaction.reporter.StandardReporter;
import transaction.reporter.BankTransactionReport;

import java.io.IOException;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {

    BankTransactionFileReader reader = new BankTransactionCSVReader();
    BankTransactionReport report = new StandardReporter();
    BankTransactionReport htmlReport = new HtmlReporter();
    BankTransactionCSVProcessor processor;
    List<String> lines;

    public void analyze(final String filePath, final Month month, BankTransactionStatementParser parser) {

        try {
            lines = reader.read(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<BankTransactionStatement> statements = parser.parse(lines);
        processor = new BankTransactionCSVProcessor(statements);
        printSummerizeInMonth(Month.JANUARY);
        printAction("January", trns -> trns.getDate().getMonth().equals(Month.JANUARY));
        printAction("Greater than 100", trns -> trns.getTotalAmount() >= 100);

        System.out.println("=====================================================================");
        printHtmlSummerizeInMonth(Month.JANUARY);
        printHtmlAction("January", trns -> trns.getDate().getMonth().equals(Month.JANUARY));
        printHtmlAction("Greater than 100", trns -> trns.getTotalAmount() >= 100);
    }

    private void printSummerizeInMonth(Month month) {
        System.out.println(report.report("Total in month [" + month.toString() + "]", processor.calculateTotalInMonth(month)));
    }

    private void printAction(String contents, BankTransactionFilter filter) {
        System.out.println(report.reportList(contents, processor.findTransactions(filter)));
    }

    private void printHtmlSummerizeInMonth(Month month) {
        System.out.println(htmlReport.report("Total in month [" + month.toString() + "]", processor.calculateTotalInMonth(month)));
    }
    private void printHtmlAction(String contents, BankTransactionFilter filter) {
        System.out.println(htmlReport.reportList(contents, processor.findTransactions(filter)));
    }

}
