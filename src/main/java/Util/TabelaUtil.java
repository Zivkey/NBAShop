package Util;

import BazaPodataka.ArtikalKontroler;
import BazaPodataka.KoriniskKontroler;
import Entiteti.Artikal;
import Entiteti.Korisnik;
import Enumi.TipArtikla;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TabelaUtil {
    /**
     * Metoda koja pravi tableView za artikle
     * @return tableView svih artikla
     */
    public static TableView artikliTabela() {
        List<Artikal> artikli = ArtikalKontroler.citajArtikle();
        TableView<Artikal> tableView = new TableView<>();

        TableColumn <Artikal, String> imeKolona = new TableColumn<>("Ime artikla");
        TableColumn <Artikal, String> tipArtikla = new TableColumn<>("Tip artikla");
        TableColumn <Artikal, Integer> cenaArtikla = new TableColumn<>("Cena");

        imeKolona.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tipArtikla.setCellValueFactory(new PropertyValueFactory<>("tipArtikla"));
        cenaArtikla.setCellValueFactory(new PropertyValueFactory<>("cena"));

        tableView.getColumns().addAll(imeKolona, tipArtikla, cenaArtikla);

        tableView.getItems().addAll(artikli);

        return tableView;

    }

    /**
     * Metoda koja pravi tableView za korisnike
     * @return tableView svih korisnika
     */
    public static TableView korisniciTabela() {
        List<Korisnik> korisnici = KoriniskKontroler.citajKorisnike();
        TableView<Korisnik> tableView = new TableView<>();

        TableColumn <Korisnik, String> userKolona = new TableColumn<>("Username");
        TableColumn <Korisnik, String> imeKolona = new TableColumn<>("Ime");
        TableColumn <Korisnik, String> prezimeKolona = new TableColumn<>("Prezime");
        TableColumn <Korisnik, String> sifraKolona = new TableColumn<>("Sifra");
        TableColumn <Korisnik, Integer> novacKolona = new TableColumn<>("Novac");
        TableColumn <Korisnik, Boolean> adminKolona = new TableColumn<>("Admin");

        userKolona.setCellValueFactory(new PropertyValueFactory<>("username"));
        imeKolona.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeKolona.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        sifraKolona.setCellValueFactory(new PropertyValueFactory<>("sifra"));
        novacKolona.setCellValueFactory(new PropertyValueFactory<>("novac"));
        adminKolona.setCellValueFactory(new PropertyValueFactory<>("admin"));

        tableView.getColumns().addAll(userKolona, imeKolona, prezimeKolona, sifraKolona, novacKolona, adminKolona);

        tableView.getItems().addAll(korisnici);

        return tableView;
    }
}
