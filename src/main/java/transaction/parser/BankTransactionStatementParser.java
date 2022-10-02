package transaction.parser;

import transaction.dto.BankTransactionStatement;

import java.util.List;

public interface BankTransactionStatementParser {
    abstract List<BankTransactionStatement> parse(List<String> lines);
    abstract BankTransactionStatement parseLine(String line);
}
