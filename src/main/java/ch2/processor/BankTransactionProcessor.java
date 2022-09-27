package ch2.processor;

import ch2.dto.BankTransactionResult;

import java.time.Month;
import java.util.List;

public interface BankTransactionProcessor {
    BankTransactionResult processInMonth(Month month);
    BankTransactionResult processTotal();
    BankTransactionResult processCategory(String category);
    BankTransactionResult processFewestBalance();
    List<BankTransactionResult> findTransactions(BankTransactionFilter filter);
    List<BankTransactionResult> processTop3();
}
