package Entiteti;

public class Dres {
    private int id;
    private Korisnik korisnik;
    private int broj;
    private String ime;
    private String klub;

    public Dres() {
    }

    public Dres(Korisnik korisnik, int broj, String ime, String klub) {
        this.korisnik = korisnik;
        this.broj = broj;
        this.ime = ime;
        this.klub = klub;
    }

    public Dres(int id, Korisnik korisnik, int broj, String ime, String klub) {
        this.id = id;
        this.korisnik = korisnik;
        this.broj = broj;
        this.ime = ime;
        this.klub = klub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKlub() {
        return klub;
    }

    public void setKlub(String klub) {
        this.klub = klub;
    }

    @Override
    public String toString() {
        return "Dres{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", broj=" + broj +
                ", ime='" + ime + '\'' +
                ", klub='" + klub + '\'' +
                '}';
    }
}
