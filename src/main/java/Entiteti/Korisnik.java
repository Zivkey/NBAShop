package Entiteti;

public class Korisnik {
    private int id;
    private String username;
    private String ime;
    private String prezime;
    private String sifra;
    private boolean admin;
    private int novac;

    public Korisnik() {
    }

    public Korisnik(String username, String ime, String prezime, String sifra, boolean admin, int novac) {
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.admin = admin;
        this.novac = novac;
    }

    public Korisnik(int id, String username, String ime, String prezime, String sifra, boolean admin, int novac) {
        this.id = id;
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.admin = admin;
        this.novac = novac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getNovac() {
        return novac;
    }

    public void setNovac(int novac) {
        this.novac = novac;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", sifra='" + sifra + '\'' +
                ", admin=" + admin +
                ", novac=" + novac +
                '}';
    }
}
