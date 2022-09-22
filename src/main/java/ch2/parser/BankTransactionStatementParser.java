package ch2.parser;

import ch2.dto.BankTransactionStatement;

import java.util.List;

public interface BankTransactionStatementParser {
    abstract List<BankTransactionStatement> parse(List<String> lines);
}
