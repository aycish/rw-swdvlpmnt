package ch2.processor;

import ch2.dto.BankTransactionResult;
import ch2.dto.BankTransactionStatement;

import java.time.Month;
import java.util.List;

public interface BankTransactionProcessor {
    BankTransactionResult processInMonth(Month month);
    BankTransactionResult processTotal();
}
