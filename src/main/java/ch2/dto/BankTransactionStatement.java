package ch2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BankTransactionStatement {
    private LocalDate date;
    private double income;
    private double spending;
}
