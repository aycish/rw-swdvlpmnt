package transaction.processor;

import transaction.dto.BankTransactionStatement;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransactionStatement bankTransactionStatement);
}
