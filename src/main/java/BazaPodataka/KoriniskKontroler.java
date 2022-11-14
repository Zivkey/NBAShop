package BazaPodataka;

import Entiteti.Korisnik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KoriniskKontroler {
    public static Connection connection;

    public static void dodajKorisnika(Korisnik korisnik) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO korisnik " +
                    "(username, ime, prezime, sifra, admin, novac) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, korisnik.getUsername());
            stmt.setString(2, korisnik.getIme());
            stmt.setString(3, korisnik.getPrezime());
            stmt.setString(4, korisnik.getSifra());
            stmt.setBoolean(5, korisnik.isAdmin());
            stmt.setInt(6, korisnik.getNovac());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Korisnik> citajKorisnike() {
        List<Korisnik> korisnici = new ArrayList<>();
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM korisnik");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Korisnik korisnik = new Korisnik();
                korisnik.setId(rs.getInt("id"));
                korisnik.setUsername(rs.getString("username"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setAdmin(rs.getBoolean("admin"));
                korisnik.setSifra(rs.getString("sifra"));
                korisnik.setNovac(rs.getInt("novac"));
                korisnici.add(korisnik);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return korisnici;
    }

    public static void updejtujKorisnika(Korisnik korisnik) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE korisnik SET username = ?, ime = ?, prezime = ?, " +
                    "sifra = ?, novac = ?, admin = ? WHERE id = ?");
            stmt.setString(1, korisnik.getUsername());
            stmt.setString(2, korisnik.getIme());
            stmt.setString(3, korisnik.getPrezime());
            stmt.setString(4, korisnik.getSifra());
            stmt.setInt(5, korisnik.getNovac());
            stmt.setBoolean(6, korisnik.isAdmin());
            stmt.setInt(7, korisnik.getId());
            stmt.execute();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
