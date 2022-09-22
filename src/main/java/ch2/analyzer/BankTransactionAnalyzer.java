package ch2.analyzer;

import ch2.dto.BankTransactionStatement;
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
        printBalanceInMonth(month);
        printBalanceWithCategory("Tesco");
        printFewestBalance();
        printTOP3Spending();
    }

    private void printTotalAmount() {
        report.report("", processor.processTotal());
    }

    private void printBalanceInMonth(Month month) {
        report.report("Month : ", processor.processInMonth(month));
    }

    private void printBalanceWithCategory(String category) {
        report.report("Category : ", processor.processCategory(category));
    }

    private void printFewestBalance() {
        report.report("Fewest Balance : ", processor.processFewestBalance());
    }

    private void printTOP3Spending() {
        report.reportList("TOP3 Spending", processor.processTop3());
    }
}
