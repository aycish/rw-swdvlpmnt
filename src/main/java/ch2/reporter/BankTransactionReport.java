package ch2.reporter;

import ch2.dto.BankTransactionResult;

import java.util.List;

public interface BankTransactionReport {
    String report(String object, BankTransactionResult result);
    List<String> reportList(String contents, List<BankTransactionResult> results);

}
