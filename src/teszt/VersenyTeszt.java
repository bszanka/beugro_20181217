package teszt;

import dalverseny.XFaktor;
import verseny.Csapat;
import verseny.Egyeni;
import verseny.Verseny;
import verseny.Versenyzo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class VersenyTeszt {

//    public void tobbCsapat(Collection<Verseny> vCol, String fajlnev){
//        new File(fajlnev);
//        int db = 0;
//        for (int i = 0; i < vCol.size(); i++) {
//        }
//
//    }


    public static void main(String[] args) {
        if(args[0].length() == 0) {
            System.err.println("Nincs megadva parancssori argumentum!");
            return;
        }

        try {
            Scanner fajl = new Scanner(new File(args[0]));
            ArrayList<Versenyzo> versenyzok = new ArrayList<Versenyzo>();
            while(fajl.hasNextLine()){
                boolean egyeni = false;
                fajl.useDelimiter(";");
                String egyeniE = fajl.next();
                if(egyeniE.endsWith("E"))   // valamiért az equals belevette az előző sor végét -- UTÁNA KELL NÉZNI
                    egyeni = true;
                int azonosito = fajl.nextInt();
                String nev = fajl.next();
                String terulet = fajl.next();
                fajl.useDelimiter("\n");
                String kor = null;
                String tagok = null;
                if(egyeni)
                    kor = fajl.next().substring(1);
                else
                    tagok = fajl.next().substring(1).replaceAll("/",", ");

                if(egyeni) 
                    versenyzok.add(new Egyeni(azonosito, nev, terulet, Integer.parseInt(kor.trim())));
                else
                    versenyzok.add(new Csapat(azonosito,nev,terulet,tagok));

            }

            ArrayList<Versenyzo> ideiVersenyzok = new ArrayList<Versenyzo>();
            XFaktor xf = new XFaktor(args[1].length() > 0 ? args[1] : "2018", ideiVersenyzok);

            for (int i = 0; i < versenyzok.size(); i++){
                if (versenyzok.get(i).getTerulet().equals("ének"))
//                    System.out.println(versenyzok.get(i));
                    xf.nevez(versenyzok.get(i));
            }
            Scanner stdin = new Scanner(System.in);
            int visszalepoAzon = stdin.nextInt();
            xf.visszalep(visszalepoAzon);
            System.out.println(xf.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Fájl nem található!");
            return;
        }



    }
}
