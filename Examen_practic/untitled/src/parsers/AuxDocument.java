package parsers;

import java.io.FileWriter;
import java.io.IOException;

public class AuxDocument {
    private String auxDocumentName = "auxDocument.txt";

    FileWriter auxiliarDoc;
    {
        try {
            auxiliarDoc = new FileWriter(auxDocumentName);
        } catch (IOException e) {
            System.out.println("No s'ha pogut crear el arxiu per alguna rao: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
