package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseAltes {
    private String path;
    public String getPath(){
        try {
            path = ParseAltes.class.getResource("altes.txt").getPath();
        } catch (NullPointerException e) {
            System.out.println("GetResporuce ha tingut un problema buscant els fitxers: " + e.getMessage());
            return null;
        }
        return path;
    }

    File file = new File(getPath());

    // inicia la lectura, preparant un arraylist
    ArrayList<String> altesText = new ArrayList<>();
    ArrayList<Integer> altesID = new ArrayList<>();

    public ArrayList<String> getAltesText() {
        return altesText;
    }

    public ArrayList<Integer> getAltesID() {
        return altesID;
    }

    // ID:TIPUS:TITOL:AUTOR:PREU:STOCK
    public void obtenirIds() {
        try(Scanner sc = new Scanner(file)) {
            int i = 0;
            while (sc.hasNextLine()) {
                // texto almacenado en el arraylist
                altesText.add(sc.nextLine());
                // done la lectura, toca separar
                String[] dataSplitted = altesText.get(i).split(":");
                // añade el int dentro de nuestro arraylist
                altesID.add(Integer.parseInt(dataSplitted[0])); // aqui es donde tendremos nuestro arraylist
                i++;
                //System.out.println(altesID.get(i - 1));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Scanner fail: No s'ha trobat el archiu " + file.getName() + ", s'haura eliminat de repent?");
            throw new RuntimeException(e);
        }
    }
}
