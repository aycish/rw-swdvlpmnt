package transaction.reporter;

import transaction.dto.BankTransactionResult;

import java.util.ArrayList;
import java.util.List;

public class HtmlReporter implements BankTransactionReport{

    @Override
    public String report(String contents, BankTransactionResult result) {
        StringBuilder builder = new StringBuilder();
        initializeHtml(builder, contents);
        builder.append("<li>" + result.toString() + "</li>");
        return builder.toString();
    }

    @Override
    public List<String> reportList(String contents, List<BankTransactionResult> results) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        initializeHtml(builder, contents);
        result.add(builder.toString());

        for(BankTransactionResult transactionResult : results) {
            result.add("<li>" + result.toString() + "</li>");
        }
        finalizeHtml(builder);
        result.add(builder.toString());

        return result;
    }

    private void initializeHtml(StringBuilder builder, String contents) {
        builder.append("<!doctype html>");
        builder.append("<html lang = 'en'>");
        builder.append("<head><title>" + contents + "</title></head>");
        builder.append("<body>");
        builder.append("<ul>");
    }

    private void finalizeHtml(StringBuilder builder) {
        builder.append("</ul>");
        builder.append("</body>");
        builder.append("</html>");
    }

}
