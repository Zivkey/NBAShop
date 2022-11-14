package Entiteti;

import Enumi.TipArtikla;

public class Artikal {
    private int id;
    private String ime;
    private String tipArtikla;
    private int cena;

    public Artikal() {
    }

    public Artikal(int id, String ime, String tipArtikla, int cena) {
        this.id = id;
        this.ime = ime;
        this.tipArtikla = tipArtikla;
        this.cena = cena;
    }

    public Artikal(String ime, String tipArtikla, int cena) {
        this.ime = ime;
        this.tipArtikla = tipArtikla;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getTipArtikla() {
        return tipArtikla;
    }

    public void setTipArtikla(String tipArtikla) {
        this.tipArtikla = tipArtikla;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Artikal{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", tipArtikla=" + tipArtikla +
                ", cena=" + cena +
                '}';
    }
}
