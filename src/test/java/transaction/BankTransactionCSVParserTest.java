package transaction;

import transaction.dto.BankTransactionStatement;
import transaction.parser.BankTransactionCSVParser;
import transaction.parser.BankTransactionStatementParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankTransactionCSVParserTest {

    private final BankTransactionStatementParser parser = new BankTransactionCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        // Given
        final String line = "30-01-2017,-50,Tesco";

        //When
        final BankTransactionStatement actual = parser.parseLine(line);
        final BankTransactionStatement expected = BankTransactionStatement.builder()
                .income(0d)
                .spending(-50d)
                .date(LocalDate.of(2017, Month.JANUARY, 30))
                .build();

        //Then
        Assertions.assertEquals(expected.getDate(), actual.getDate());
        Assertions.assertEquals(expected.getSpending(), actual.getSpending());
        Assertions.assertEquals(expected.getIncome(), actual.getIncome());
        Assertions.assertEquals(expected.getDate(), actual.getDate());
    }
}
