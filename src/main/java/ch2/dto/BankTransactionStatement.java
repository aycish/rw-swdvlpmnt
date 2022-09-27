package ch2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BankTransactionStatement {
    private LocalDate date;
    private String category;
    private double income;
    private double spending;

    public BankTransactionResult toResult() {
        return BankTransactionResult.builder().income(income).spending(spending).category(category).build();
    }

    public double getTotalAmount() {
        return income + spending;
    }
}
