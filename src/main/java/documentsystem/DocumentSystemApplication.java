package documentsystem;

import documentsystem.system.DocumentManagementSystem;

import java.io.IOException;

public class DocumentSystemApplication {

    private static final String LETTER = "src/main/resources/documentsystem/letter1.letter";
    private static final String IMAGE = "src/main/resources/documentsystem/image1.jpg";
    private static final String REPORT = "src/main/resources/documentsystem/report1.report";

    public static void main(String[] args) {
        DocumentManagementSystem system = new DocumentManagementSystem();
        try {
            system.importFile(LETTER);
            system.importFile(IMAGE);
            system.importFile(REPORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(system.contents());
        system.contents().forEach(doc -> System.out.println(doc.hasContained("Dear")));
    }
}
