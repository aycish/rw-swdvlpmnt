package documentsystem.system;

import documentsystem.constants.ImporterType;
import documentsystem.document.Document;
import documentsystem.importer.ImageImporter;
import documentsystem.importer.Importer;
import documentsystem.importer.LetterImporter;
import documentsystem.importer.ReportImporter;
import documentsystem.util.DocumentSystemUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class DocumentManagementSystem {

    private final EnumMap<ImporterType, Importer> extensionToImporter = new EnumMap<>(ImporterType.class);
    private final List<Document> documents = new ArrayList<>();

    public DocumentManagementSystem() {
        extensionToImporter.put(ImporterType.IMAGE, new ImageImporter());
        extensionToImporter.put(ImporterType.LETTER, new LetterImporter());
        extensionToImporter.put(ImporterType.REPORT, new ReportImporter());
    }

    /**
     * 사용자가 문서 관리 시스템으로 관리하고자하는 파일을 등록
     *
     * @param path 대상의 파일 경로를 입력 받는다.
     */
    public void importFile(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException(path);

        final Document document = extensionToImporter.get(ImporterType.valueOf(DocumentSystemUtility.getFileExtension(file.getName()).toUpperCase())).importFile(file);
        documents.add(document);
    }

    /**
     * 문서 관리 시스템에 저장된 모든 문서의 목록을 반환한다.
     * @return 등록된 모든 문서의 목록
     */
    public List<Document> contents() {
        return documents;
    }

}
