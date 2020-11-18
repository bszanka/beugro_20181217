package teszt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VersenyTeszt {

    public static void main(String[] args) {

        try {
            Scanner fajl = new Scanner(new File(args[0]));
            ArrayList<String> versenyzok = null;
            while(fajl.hasNextLine()){
                versenyzok.add(fajl.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Fájl nem található!");
        }


    }
}
