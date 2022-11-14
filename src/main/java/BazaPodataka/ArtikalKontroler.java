package BazaPodataka;

import Entiteti.Artikal;
import Enumi.TipArtikla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtikalKontroler {
    public static Connection connection;

    public static void dodajArtikal(Artikal artikal) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO artikal " +
                    "(ime, tip_artikla, cena) VALUES (?, ?, ?)");
            stmt.setString(1, artikal.getIme());
            stmt.setString(2, String.valueOf(artikal.getTipArtikla()));
            stmt.setInt(3, artikal.getCena());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Artikal> citajArtikle() {
        List<Artikal> artikli = new ArrayList<>();
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artikal");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Artikal artikal = new Artikal();
                artikal.setId(rs.getInt("id"));
                artikal.setIme(rs.getString("ime"));
                artikal.setCena(rs.getInt("cena"));
                artikal.setTipArtikla((rs.getString("tip_artikla")));
                artikli.add(artikal);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return artikli;
    }

    public static void updejtujArtikal(Artikal artikal) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE artikal SET ime = ?, " +
                    "cena = ?, tip_arikla = ? WHERE id = ?");
            stmt.setString(1, artikal.getIme());
            stmt.setInt(2, artikal.getCena());
            stmt.setString(3, String.valueOf(artikal.getTipArtikla()));
            stmt.setInt(4, artikal.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void obrisiArtikal(Artikal artikal) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM artikal WHERE id = ?");
            stmt.setInt(1, artikal.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
