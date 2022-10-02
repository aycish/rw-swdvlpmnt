package documentsystem.util;

import java.io.File;

public class DocumentSystemUtility {

    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
