package transaction.parser;

import transaction.dto.BankTransactionStatement;
import transaction.exception.Notification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionCSVParser implements BankTransactionStatementParser{

    final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    final Notification notification = new Notification();

    @Override
    public List<BankTransactionStatement> parse(List<String> lines) {

        List<BankTransactionStatement> bankTransactionStatements = new ArrayList<>();

        for (String line : lines) {
            bankTransactionStatements.add(parseLine(line));
        }

        return bankTransactionStatements;
    }

    @Override
    public BankTransactionStatement parseLine(String line) {
        final String[] columns = line.split(",");
        LocalDate localDate = null;

        try {
            localDate = LocalDate.parse(columns[0], DATE_FORMAT);
        } catch (DateTimeParseException e) {
            notification.addError("Invalid format for date");
        }

        double income = 0d;
        double spending = 0d;
        double amount = 0d;

        try {
            amount = Double.parseDouble(columns[1]);
        } catch (NumberFormatException e) {
            notification.addError("Invalid format for amount");
        }

        if (amount > 0)
            income = amount;
        else
            spending = amount;

        return BankTransactionStatement.builder()
                .income(income)
                .spending(spending)
                .date(localDate)
                .category(columns[2])
                .build();
    }
}
