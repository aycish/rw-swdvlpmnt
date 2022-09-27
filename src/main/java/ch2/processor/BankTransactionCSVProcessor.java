package ch2.processor;

import ch2.dto.BankTransactionResult;
import ch2.dto.BankTransactionStatement;

import java.time.Month;
import java.util.*;

public class BankTransactionCSVProcessor {

    private final List<BankTransactionStatement> statements;

    public BankTransactionCSVProcessor(final List<BankTransactionStatement> statements) {
        this.statements = statements;
    }

    public BankTransactionResult summerizeTransactions(BankResultSummerizer summerizer) {
        BankTransactionResult result = null;

        for (final BankTransactionStatement statement : statements) {
            result = summerizer.summerize(statement, result);
        }

        return result;
    }

    public BankTransactionResult calculateTotalInMonth(final Month month) {
        return summerizeTransactions((statement, result) -> {

            if (statement.getDate().getMonth().equals(month)) {
                if (result == null) return statement.toResult();

                result.setIncome(statement.getIncome() + result.getIncome());
                result.setSpending(statement.getSpending() + result.getSpending());
            }

            return result;
        });
    }

    public List<BankTransactionResult> findTransactions(BankTransactionFilter filter) {
        List<BankTransactionResult> results = new ArrayList<>();

        for (BankTransactionStatement statement : statements) {
            if (filter.test(statement)) results.add(statement.toResult());
        }

        return results;
    }


}
