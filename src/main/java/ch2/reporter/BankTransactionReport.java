package ch2.reporter;

import ch2.dto.BankTransactionResult;

import java.time.Month;

public interface BankTransactionReport {
    void report(String object,BankTransactionResult result);

}
