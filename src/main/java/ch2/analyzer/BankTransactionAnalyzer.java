package ch2.analyzer;

import ch2.dto.BankTransactionStatement;
import ch2.parser.BankTransactionStatementParser;
import ch2.processor.BankTransactionCSVProcessor;
import ch2.processor.BankTransactionFilter;
import ch2.reader.BankTransactionCSVReader;
import ch2.reader.BankTransactionFileReader;
import ch2.reporter.StandardReporter;
import ch2.reporter.BankTransactionReport;

import java.io.IOException;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {

    BankTransactionFileReader reader = new BankTransactionCSVReader();
    BankTransactionReport report = new StandardReporter();
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
    }

    private void printSummerizeInMonth(Month month) {
        report.report("Total in month [" + month.toString() + "]", processor.calculateTotalInMonth(month));
    }

    private void printAction(String contents, BankTransactionFilter filter) {
        report.reportList(contents, processor.findTransactions(filter));
    }
}
