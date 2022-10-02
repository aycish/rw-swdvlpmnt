package transaction.reporter;

import transaction.dto.BankTransactionResult;

import java.util.List;

public interface BankTransactionReport {
    String report(String object, BankTransactionResult result);
    List<String> reportList(String contents, List<BankTransactionResult> results);

}
