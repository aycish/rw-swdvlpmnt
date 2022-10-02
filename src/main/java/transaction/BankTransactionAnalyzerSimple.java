package transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);

        printBalance(lines);
        printJanTransactionCount(lines);
    }

    private static void printBalance(List<String> lines) {
        double income = 0d;
        double spending = 0d;

        for (String line : lines) {
            final String[] colums = line.split(",");
            double amount = Double.parseDouble(colums[1]);

            if (amount > 0d) income += amount;
            else spending += amount;

        }

        System.out.println(MessageFormat.format("Income = {0}, Spending = {1}, Balance = {2}", income, spending, income + spending));
    }

    private static void printJanTransactionCount(List<String> lines) {
        int count = 0;
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (String line : lines) {
            final String[] colums = line.split(",");
            final LocalDate date = LocalDate.parse(colums[0], dateTimeFormatter);

            if (!date.getMonth().equals(Month.JANUARY))
                continue;

            count ++;
        }
        System.out.println(MessageFormat.format("Transaction Count for {0} is {1}", Month.JANUARY, count));
    }

}
