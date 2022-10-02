package transaction.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankTransactionResult {
    @Builder.Default
    private String category = "";
    @Builder.Default
    private double income = 0d;
    @Builder.Default
    private double spending = 0d;
}
