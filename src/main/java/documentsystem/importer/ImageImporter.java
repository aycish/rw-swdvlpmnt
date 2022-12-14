package documentsystem.importer;

import documentsystem.constants.Attribute;
import documentsystem.constants.ImporterType;
import documentsystem.document.Document;
import documentsystem.util.DocumentSystemUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.EnumMap;

public class ImageImporter implements Importer {
    private static final String EXTENSION = "image";

    @Override
    public Document importFile(File file) {
        if (!DocumentSystemUtility.getFileExtension(file.getName()).equals(EXTENSION))
            throw new IllegalArgumentException("File extension has to be " + EXTENSION);

        EnumMap<Attribute, String> attributes = new EnumMap<>(Attribute.class);

        attributes.put(Attribute.PATH, file.getPath());
        attributes.put(Attribute.TYPE, EXTENSION);

        return Document.builder().attributes(attributes).lines(new ArrayList<>()).type(ImporterType.valueOf(EXTENSION.toUpperCase())).build();
    }
}
