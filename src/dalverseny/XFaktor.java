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

    }

    @Override
    public boolean visszalep(int azonosito) {
        return false;
    }

    @Override
    public int[] versenyzokSzama() {
        return new int[0];
    }

    @Override
    public String toString() {
        return "X-Faktor - " + evad + "\n" + versenyzok;
    }
}
