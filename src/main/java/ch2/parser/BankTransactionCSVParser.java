package ch2.parser;

import ch2.dto.BankTransactionStatement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionCSVParser implements BankTransactionStatementParser{

    final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<BankTransactionStatement> parse(List<String> lines) {

        List<BankTransactionStatement> bankTransactionStatements = new ArrayList<>();

        for (String line : lines) {
            bankTransactionStatements.add(parseLine(line));
        }

        return bankTransactionStatements;
    }

    private BankTransactionStatement parseLine(String line) {
        final String[] columns = line.split(",");
        final LocalDate localDate = LocalDate.parse(columns[0], DATE_FORMAT);

        double income = 0d;
        double spending = 0d;
        double amount = Double.parseDouble(columns[1]);

        if (amount > 0)
            income = amount;
        else
            spending = amount;

        return BankTransactionStatement.builder()
                .income(income)
                .spending(spending)
                .date(localDate)
                .build();

    }
}
