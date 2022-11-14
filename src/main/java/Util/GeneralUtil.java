package Util;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Korisnik;

import java.util.List;

public class GeneralUtil {
    /**
     * Metoda koja proverava da li je username unikatan
     * @param s username
     * @return da li je on unikatan
     */
    public static boolean proveriUsername(String s) {
        List<Korisnik> korisnici = KoriniskKontroler.citajKorisnike();
        for (Korisnik x : korisnici) {
            if (x.getUsername().equals(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metoda koja proverava da li je string sacinen samo od slova
     * @param s rec koju proveravamo
     * @return da li je samo slova
     */
    public static boolean samoSlova(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return false;
        }
        char [] niz = s.toCharArray();
        for (char x : niz) {
            if (!Character.isLetter(x)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metoda koja proverava da li je string sacinjen samo od cifara
     * @param s string koji proveravamo
     * @return da li je sacinjen samo od cifara
     */
    public static boolean samoCifre(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return false;
        }
        char [] niz = s.toCharArray();
        for (char x : niz) {
            if (!Character.isDigit(x)) {
                return false;
            }
        }
        return true;
    }
}
