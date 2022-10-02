package documentsystem.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DocumentSystemUtilityTest {

    DocumentSystemUtility utility = new DocumentSystemUtility();

    @DisplayName("getExtension 함수 테스트")
    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {"report.report,report","letter1.letter,letter","image1.jpg,jpg"})
    void testGetExtension(String fileName, String extension) {
        Assertions.assertEquals(extension, utility.getFileExtension(fileName));
    }
}
