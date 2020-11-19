package dalverseny;

import verseny.Verseny;
import verseny.Versenyzo;

import java.util.ArrayList;

public class XFaktor implements Verseny {

    private String evad;
    private ArrayList<Versenyzo> versenyzok;

    public XFaktor(String evad, ArrayList<Versenyzo> versenyzok) {
        this.evad = evad;
        this.versenyzok = versenyzok;
    }

    @Override
    public void nevez(Versenyzo versenyzo) {
            this.versenyzok.add(versenyzo);
    }

    @Override
    public boolean visszalep(int azonosito) {
        for (int i = 0; i < versenyzok.size(); i++) {
            if(versenyzok.get(i).getAzonosito() == azonosito)
            {
                this.versenyzok.remove(i);
                return true;
            }
        }
        System.out.println("Nem találtunk a megadott azonosítójú versenyzőt!");
        return false;
    }

    @Override
    public int[] versenyzokSzama() {
        return new int[0];
    }

    @Override
    public String toString() {
        String res = "X-Faktor - " + evad + "\n\n";
        for (int i = 0; i < versenyzok.size(); i++){
            res += versenyzok.get(i).toString();
            if(i < versenyzok.size()-1)
            res += "\n";
        }

        return res;
    }
}
