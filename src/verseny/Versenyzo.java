package verseny;

import java.util.Objects;

//  3. feladatnál mindig írjuk oda a Comparable-hoz az Absztrakt osztályt mint típust!
public abstract class Versenyzo implements Comparable<Versenyzo> {
    //  1. feladat
    protected int azonosito;
    protected String nev;
    protected String terulet;

    public Versenyzo(int azonosito, String nev, String terulet) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.terulet = terulet;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(int azonosito) {
        this.azonosito = azonosito;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTerulet() {
        return terulet;
    }

    public void setTerulet(String terulet) {
        this.terulet = terulet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Versenyzo)) return false;
        Versenyzo versenyzo = (Versenyzo) o;
        return azonosito == versenyzo.azonosito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(azonosito);
    }

    //  2. feladat
    @Override
    public String toString() {
        return nev + " (" + terulet + "), azonosítója: " + azonosito;
    }

    //  3. feladat  --  tipp a Comparable-hoz @ line ~5
    @Override
    public int compareTo(Versenyzo o) {
        int kulonbseg = terulet.compareTo(o.terulet);
        if(kulonbseg != 0)
            return kulonbseg;
        int kulonbseg2 = nev.compareTo(o.nev);
        if(kulonbseg2 != 0)
            return kulonbseg2;
        return Integer.compare(azonosito,o.azonosito);
    }
}
