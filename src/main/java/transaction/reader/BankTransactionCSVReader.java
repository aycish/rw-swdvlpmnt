package transaction.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionCSVReader implements BankTransactionFileReader{
    @Override
    public List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
