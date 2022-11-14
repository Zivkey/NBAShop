package Scenes.KorisnikScene;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Artikal;
import Entiteti.Korisnik;
import Scenes.Login;
import Util.FxUtil;
import Util.TabelaUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KupiArtikal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Kupite artikle koje zelite");
    private Label stanjeLabel = new Label("Vase stanje na racunu je " + Login.getTrenutniKorisnik().getNovac() + " rsd.");
    private Label porukaLabel = new Label("");

    private Button kupiDugme = new Button("Kupi artikal");
    private Button nazadDugme = new Button("Nazad");
    private TableView<Artikal> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        tableView = TabelaUtil.artikliTabela();
        HBox dugmici = FxUtil.napraviButtonBox(nazadDugme, kupiDugme);
        VBox root = FxUtil.napraviRoot(naslovLabel, stanjeLabel, tableView, porukaLabel, dugmici);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Kupi artikle");
        primaryStage.setScene(scene);
        primaryStage.show();

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new KorisnikMeni().start(primaryStage);
        });

        kupiDugme.setOnAction(actionEvent -> {
                    Artikal a1 = tableView.getSelectionModel().getSelectedItem();
                    if (Login.getTrenutniKorisnik().getNovac() < tableView.getSelectionModel().getSelectedItem().getCena()) {
                        porukaLabel.setText("Nemate dovoljno novca!");
                        porukaLabel.setTextFill(Color.RED);
                    } else {
                        porukaLabel.setText("Kupili ste jedan " + tableView.getSelectionModel().getSelectedItem().getIme());
                        porukaLabel.setTextFill(Color.GREEN);
                        Korisnik korisnik = Login.getTrenutniKorisnik();
                        korisnik.setNovac(korisnik.getNovac() - tableView.getSelectionModel().getSelectedItem().getCena());
                        Login.setTrenutniKorisnik(korisnik);
                        KoriniskKontroler.updejtujKorisnika(korisnik);
                        stanjeLabel.setText("Vase stanje na racunu je " + Login.getTrenutniKorisnik().getNovac() + " rsd.");
                    }
        });

    }
}
