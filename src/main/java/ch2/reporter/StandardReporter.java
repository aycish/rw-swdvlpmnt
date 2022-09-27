package ch2.reporter;

import ch2.dto.BankTransactionResult;

import java.text.MessageFormat;
import java.util.List;

import static java.lang.System.*;

public class StandardReporter implements BankTransactionReport{

    private static final String MESSAGE_FORMAT = "[{0}] Income = {1}, Spending = {2}, Balance = {3}";

    @Override
    public void report(String object, BankTransactionResult result) {
        out.println(MessageFormat.format(MESSAGE_FORMAT, object + result.getCategory(), result.getIncome(), result.getSpending(), result.getIncome() + result.getSpending()));
    }

    @Override
    public void reportList(String object, List<BankTransactionResult> results) {
        out.println(MessageFormat.format("####### {0} #######", object));
        for (BankTransactionResult result : results) {
            report("", result);
        }
    }

}
