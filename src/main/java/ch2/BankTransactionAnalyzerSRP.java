package ch2;

import ch2.analyzer.BankTransactionAnalyzer;
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
    private static BankTransactionStatementParser parser = new BankTransactionCSVParser();
    public static void main(String[] args) {
        BankTransactionAnalyzer analyzer = new BankTransactionAnalyzer();
        analyzer.analyze(RESOURCES + args[0], Month.of(Integer.parseInt(args[1])), parser);
    }
}
