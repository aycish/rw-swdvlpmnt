package ch2;

import ch2.analyzer.BankTransactionAnalyzer;
import ch2.parser.BankTransactionCSVParser;
import ch2.parser.BankTransactionStatementParser;

import java.time.Month;

public class BankTransactionAnalyzerSRP {

    private static final String RESOURCES = "src/main/resources/";
    private static BankTransactionStatementParser parser = new BankTransactionCSVParser();
    public static void main(String[] args) {
        BankTransactionAnalyzer analyzer = new BankTransactionAnalyzer();
        analyzer.analyze(RESOURCES + args[0], Month.of(Integer.parseInt(args[1])), parser);
    }
}
