package ch2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);

        double totalAmount = 0d;
        double income = 0d;
        double spending = 0d;

        for (String line : lines) {
            String[] colums = line.split(",");
            double amount = Double.parseDouble(colums[1]);

            if (amount > 0d) income += amount;
            else spending += amount;

        }

        totalAmount = income + spending;
        System.out.println(MessageFormat.format("Income = {0}, Spending = {1}, Balance = {2}", income, spending, totalAmount));
    }
}
