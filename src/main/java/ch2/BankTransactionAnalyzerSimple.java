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

        for (String line : lines) {
            String[] colums = line.split(",");
            System.out.println(colums[1]);
            totalAmount += Double.parseDouble(colums[1]);
        }

        System.out.println(MessageFormat.format("Balance = {0}", totalAmount));
    }
}
