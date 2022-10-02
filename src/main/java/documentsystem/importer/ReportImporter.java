package documentsystem.importer;

import documentsystem.constants.Attribute;
import documentsystem.document.Document;
import documentsystem.util.DocumentSystemUtility;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Data
@Builder
@RequiredArgsConstructor
public class ReportImporter implements Importer {

    private static final String EXTENSION = "report";

    /**
     * Report 파일을 Document 타입으로 변환
     * @param file Document 타입으로 변환할 File 객체
     * @return 변환된 Document 타입
     * @throw IllegalArgumentException : 파일이 존재하지 않거나, 파일 확장자가 report가 아닐 경우 발생
     */
    @Override
    public Document importFile(File file) {
        /* validation logic : extension Check */
        if (!file.exists()) throw new IllegalArgumentException("File not exist");
        if (!DocumentSystemUtility.getFileExtension(file.getName()).equals(EXTENSION))
            throw new IllegalArgumentException("File extension has to be " + EXTENSION);

        EnumMap<Attribute, String> attributes = new EnumMap<>(Attribute.class);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        attributes.put(Attribute.PATH, file.getPath());
        attributes.put(Attribute.TYPE, EXTENSION);
        attributes.put(Attribute.PATIENT, DocumentSystemUtility.getFileExtension(file.getName()));

        return Document.builder().attributes(attributes).lines(lines).build();
    }

    private String getPatientName(List<String> lines) {
        Optional<String> patientLine = lines.stream().filter(line -> line.contains("Patient")).findFirst();

        if (patientLine.isPresent()) return patientLine.get().substring(patientLine.get().lastIndexOf(":")).trim();
        else return "";
    }
}
