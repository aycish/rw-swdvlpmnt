package transaction.reporter;

import transaction.dto.BankTransactionResult;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class StandardReporter implements BankTransactionReport{

    private static final String MESSAGE_FORMAT = "[{0}] Income = {1}, Spending = {2}, Balance = {3}";

    @Override
    public String report(String contents, BankTransactionResult result) {
        return MessageFormat.format(MESSAGE_FORMAT, (contents.isEmpty() ? result.getCategory() : contents), result.getIncome(), result.getSpending(), result.getIncome() + result.getSpending()).toString();
    }

    @Override
    public List<String> reportList(String contents, List<BankTransactionResult> results) {
        List<String> messages = new ArrayList<>();
        messages.add(MessageFormat.format("####### {0} #######", contents).toString());
        for (BankTransactionResult result : results) {
            messages.add("\n");
            messages.add(report("", result));
        }
        return messages;
    }

}
