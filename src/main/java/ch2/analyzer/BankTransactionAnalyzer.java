package ch2.analyzer;

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

public class BankTransactionAnalyzer {

    BankTransactionFileReader reader = new BankTransactionCSVReader();
    BankTransactionReport report = new BankTransactionCSVReport();
    BankTransactionProcessor processor;
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
        printTotalAmount();
        printBanlanceInMonth(month);
    }

    private void printTotalAmount() {
        report.report(processor.processTotal());
    }

    private void printBanlanceInMonth(Month month) {
        report.reportInMonth(processor.processInMonth(month),month);
    }
}
