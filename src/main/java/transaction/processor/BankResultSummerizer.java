package transaction.processor;

import transaction.dto.BankTransactionResult;
import transaction.dto.BankTransactionStatement;

@FunctionalInterface
public interface BankResultSummerizer {
    BankTransactionResult summerize(BankTransactionStatement statement, BankTransactionResult result);
}
