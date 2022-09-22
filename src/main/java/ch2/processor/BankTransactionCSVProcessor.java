package ch2.processor;

import ch2.dto.BankTransactionResult;
import ch2.dto.BankTransactionStatement;

import java.time.Month;
import java.util.List;

public class BankTransactionCSVProcessor implements BankTransactionProcessor {

    private final List<BankTransactionStatement> statements;

    public BankTransactionCSVProcessor(final List<BankTransactionStatement> statements) {
        this.statements = statements;
    }

    @Override
    public BankTransactionResult processInMonth(Month month) {
        double income = 0d;
        double spending = 0d;
        int count = 0;

        for (BankTransactionStatement statement : statements) {
            if (statement.getDate().getMonth().equals(month)) {
                income += statement.getIncome();
                spending += statement.getSpending();
                count++;
            }
        }

        return BankTransactionResult.builder()
                .income(income)
                .spending(spending)
                .count(count)
                .build();
    }

    @Override
    public BankTransactionResult processTotal() {
        double income = 0d;
        double spending = 0d;
        int count = 0;
        for (BankTransactionStatement statement : statements) {
            income += statement.getIncome();
            spending += statement.getSpending();
            count++;
        }

        return BankTransactionResult.builder()
                .income(income)
                .spending(spending)
                .count(count)
                .build();
    }
}
