package BazaPodataka;

import Entiteti.Dres;
import Entiteti.Korisnik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DresKontroler {
    public static Connection connection;

    public static void dodajDres(Dres dres) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO dres " +
                    " (id_korisnika, broj, ime, klub) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, dres.getKorisnik().getId());
            stmt.setInt(2, dres.getBroj());
            stmt.setString(3, dres.getIme());
            stmt.setString(4, dres.getKlub());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Dres> citajDresove() {
        List<Dres> dresovi = new ArrayList<>();
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM dres");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dres dres = new Dres();
                dres.setId(rs.getInt("id"));
                dres.setIme(rs.getString("ime"));
                dres.setBroj(rs.getInt("broj"));
                dres.setKlub(rs.getString("klub"));
                int id_korisnika = rs.getInt("id_korisnika");
                List<Korisnik> korisnici = KoriniskKontroler.citajKorisnike();
                for (Korisnik x : korisnici) {
                    if (x.getId() == id_korisnika) {
                        dres.setKorisnik(x);
                        break;
                    }
                }
                dresovi.add(dres);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dresovi;
    }
}
