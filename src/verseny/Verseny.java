package verseny;

public interface Verseny {
    // új versenyzőt nevez a versenybe, ha még eddig nem volt
    public void nevez(Versenyzo versenyzo);
    // visszaléptet egy azonosítóval megadott versenyzőt a versenyből; igazzal tér
    // vissza, ha a megadott versenyző nevezve volt a versenybe, különben hamissal
    public boolean visszalep(int azonosito);
    // visszaad egy kételemű tömböt, amelynek az első eleme a versenybe nevezett
    // egyéni versenyzők, a második eleme pedig a versenybe nevezett csapatok számát
    // adja meg
    public int[] versenyzokSzama();
}
