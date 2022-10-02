package documentsystem.importer;

import documentsystem.constants.Attribute;
import documentsystem.constants.ImporterType;
import documentsystem.document.Document;
import documentsystem.util.DocumentSystemUtility;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import static documentsystem.constants.Attribute.*;

@Data
@Builder
@RequiredArgsConstructor
public class LetterImporter implements Importer{
    private static final String EXTENSION = "letter";

    @Override
    public Document importFile(File file) {
        /* validation logic : extension Check */
        if (!DocumentSystemUtility.getFileExtension(file.getName()).equals(EXTENSION))
            throw new IllegalArgumentException("File extension has to be " + EXTENSION);

        EnumMap<Attribute, String> attributes = new EnumMap<>(Attribute.class);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        attributes.put(PATH, file.getPath());
        attributes.put(TYPE, EXTENSION);
        attributes.put(PATIENT, getPatientName(lines));

        return Document.builder().attributes(attributes).lines(lines).type(ImporterType.valueOf(EXTENSION.toUpperCase())).build();
    }

    private String getPatientName(List<String> lines) {
        Optional<String> patientLine = lines.stream().filter(line -> line.contains("Dear")).findFirst();

        if (patientLine.isPresent()) return patientLine.get().substring(patientLine.get().lastIndexOf("Dear")).trim();
        else return "";
    }
}
