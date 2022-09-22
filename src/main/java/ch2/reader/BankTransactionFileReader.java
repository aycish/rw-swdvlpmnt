package ch2.reader;

import java.io.IOException;
import java.util.List;

public interface BankTransactionFileReader {
    List<String> read(String path) throws IOException;
}
