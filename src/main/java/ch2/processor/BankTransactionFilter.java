package ch2.processor;

import ch2.dto.BankTransactionStatement;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransactionStatement bankTransactionStatement);
}
