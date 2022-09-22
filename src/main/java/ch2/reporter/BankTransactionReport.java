package ch2.reporter;

import ch2.dto.BankTransactionResult;

import java.time.Month;
import java.util.List;

public interface BankTransactionReport {
    void report(String object, BankTransactionResult result);
    void reportList(String object, List<BankTransactionResult> results);

}
