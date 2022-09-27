package ch2.processor;

import ch2.dto.BankTransactionResult;
import ch2.dto.BankTransactionStatement;

@FunctionalInterface
public interface BankResultSummerizer {
    BankTransactionResult summerize(BankTransactionStatement statement, BankTransactionResult result);
}
