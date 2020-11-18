package verseny;

public class Csapat extends Versenyzo {
    private String tagok;

    public Csapat(int azonosito, String nev, String terulet, String tagok) {
        super(azonosito, nev, terulet);
        this.tagok = tagok;
    }

    @Override
    public String toString() {
        return "csapat: " + super.toString() + ", tagjai: " + tagok;
    }
}
