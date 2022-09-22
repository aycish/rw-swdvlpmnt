package ch2.reporter;

import ch2.dto.BankTransactionResult;

import java.text.MessageFormat;
import java.time.Month;

public class BankTransactionCSVReport implements BankTransactionReport{

    private static final String MESSAGE_FORMAT = "[{0}] Income = {1}, Spending = {2}, Balance = {3}";
    private static final String TOTAL = "Total";
    @Override
    public void report(BankTransactionResult result) {
        System.out.println(MessageFormat.format(MESSAGE_FORMAT, TOTAL, result.getIncome(), result.getSpending(), result.getIncome() + result.getSpending()));
    }

    @Override
    public void reportInMonth(BankTransactionResult result, Month month) {
        System.out.println(MessageFormat.format(MESSAGE_FORMAT, month.toString(), result.getIncome(), result.getSpending(), result.getIncome() + result.getSpending()));
    }
}
