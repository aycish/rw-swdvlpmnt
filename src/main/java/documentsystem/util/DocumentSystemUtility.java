package documentsystem.util;

import java.io.File;

public class DocumentSystemUtility {

    public static String getFileExtension(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

        if (extension.equals("jpg")) return "image";

        return extension;
    }
}
