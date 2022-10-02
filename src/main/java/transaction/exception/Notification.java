package transaction.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(final String message) {
        errors.add(message);
    }

    public boolean hasError() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.toString();
    }
}
