package documentsystem.importer;

import documentsystem.document.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFile(File file);
}
