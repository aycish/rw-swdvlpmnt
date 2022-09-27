package ch2.processor;

import ch2.dto.BankTransactionResult;
import ch2.dto.BankTransactionStatement;

import java.time.Month;
import java.util.*;

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
                .category(month.toString())
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
                .category("Total")
                .build();
    }

    @Override
    public BankTransactionResult processCategory(String category) {
        double income = 0d;
        double spending = 0d;
        int count = 0;
        for (BankTransactionStatement statement : statements) {
            if (statement.getCategory().equals(category)) {
                income += statement.getIncome();
                spending += statement.getSpending();
                count++;
            }
        }

        return BankTransactionResult.builder()
                .income(income)
                .spending(spending)
                .count(count)
                .category(category)
                .build();
    }

    @Override
    public BankTransactionResult processFewestBalance() {
        BankTransactionStatement fewest = null;
        for (BankTransactionStatement statement : statements) {
            if (fewest == null || statement.getTotalAmount() < fewest.getTotalAmount()) {
                fewest = statement;
            }
        }

        BankTransactionResult result = fewest.toResult();
        return result;
    }

    @Override
    public List<BankTransactionResult> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransactionResult> results = new ArrayList<>();

        for (BankTransactionStatement statement : statements) {
            if (statement.getIncome() + statement.getSpending() >= amount) {
                BankTransactionResult result = statement.toResult();
                results.add(result);
            }
        }

        return results;
    }

    @Override
    public List<BankTransactionResult> findTransactionsInMonth(Month month) {
        final List<BankTransactionResult> results = new ArrayList<>();

        for (BankTransactionStatement statement : statements) {
            if (statement.getDate().getMonth().equals(month)) {
                results.add(statement.toResult());
            }
        }

        return results;
    }

    @Override
    public List<BankTransactionResult> processTop3() {
        List<BankTransactionResult> results = new ArrayList<>();
        Set<String> categories = new HashSet<>();

        for (BankTransactionStatement statement : statements) {
            categories.add(statement.getCategory());
        }

        for (String category : categories) {
            results.add(processCategory(category));
        }

        results.sort(Comparator.comparing((BankTransactionResult::getSpending)));
        return results.subList(0, 3);
    }
}
