package ch2;

import ch2.dto.BankTransactionStatement;
import ch2.parser.BankTransactionCSVParser;
import ch2.parser.BankTransactionStatementParser;
import ch2.processor.BankTransactionCSVProcessor;
import ch2.processor.BankTransactionProcessor;
import ch2.reader.BankTransactionCSVReader;
import ch2.reader.BankTransactionFileReader;
import ch2.reporter.BankTransactionCSVReport;
import ch2.reporter.BankTransactionReport;

import java.io.IOException;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerSRP {

    private static final String RESOURCES = "src/main/resources/";
    static BankTransactionFileReader reader = new BankTransactionCSVReader();
    static BankTransactionStatementParser parser = new BankTransactionCSVParser();
    static BankTransactionProcessor processor = new BankTransactionCSVProcessor();
    static BankTransactionReport report = new BankTransactionCSVReport();
    static List<String> lines;

    public static void main(String[] args) {

        try {
            lines = reader.read(RESOURCES + args[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<BankTransactionStatement> statements = parser.parse(lines);
        printTotalAmount(statements);
        printBanlanceInMonth(statements, Month.of(Integer.parseInt(args[1])));
    }

    private static void printTotalAmount(List<BankTransactionStatement> statements) {
        report.report(processor.processTotal(statements));
    }

    private static void printBanlanceInMonth(List<BankTransactionStatement> statements, Month month) {
        report.reportInMonth(processor.processInMonth(statements, month),month);
    }
}
