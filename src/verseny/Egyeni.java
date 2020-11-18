package verseny;

public class Egyeni extends Versenyzo {
    private int kor;

    public Egyeni(int azonosito, String nev, String terulet, int kor) {
        super(azonosito, nev, terulet);
        this.kor = kor;
    }

    @Override
    public String toString() {
        return "egyéni versenyző: " + super.toString()
                + ", kora: " + kor + " év";
    }

}
