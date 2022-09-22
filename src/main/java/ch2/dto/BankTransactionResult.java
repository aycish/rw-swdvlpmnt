package ch2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankTransactionResult {
    private String category;
    private double income;
    private double spending;
    private int count;
}
