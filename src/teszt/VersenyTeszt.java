package teszt;

import verseny.Csapat;
import verseny.Egyeni;
import verseny.Versenyzo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VersenyTeszt {

    public static void main(String[] args) {
        if(args[0].length() == 0) {
            System.err.println("Nincs megadva parancssori argumentum!");
            return;
        }

        try {
            Scanner fajl = new Scanner(new File(args[0]));
            List<Versenyzo> versenyzok = null;
            while(fajl.hasNextLine()){
                boolean egyeni = false;
                fajl.useDelimiter(";");
                String egyeniE = fajl.next();
                if(egyeniE.endsWith("E"))   // valamiért az equals belevette az előző sor végét -- UTÁNA KELL NÉZNI
                    egyeni = true;
                int azonosito = fajl.nextInt();
                String nev = fajl.next();
                String terulet = fajl.next();
                String kor = null;
                String tagok = null;
                fajl.useDelimiter("\n");
                if(egyeni)
                    kor = fajl.next().substring(1);
                else
                    tagok = fajl.next().substring(1).replaceAll("/",", ");
                if(egyeni)
                    versenyzok.add(new Egyeni(azonosito,nev,terulet,Integer.parseInt(kor)));
                else
                    versenyzok.add(new Csapat(azonosito,nev,terulet,tagok));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Fájl nem található!");
            return;
        }


    }
}
