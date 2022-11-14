package Scenes.AdminScene;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Korisnik;
import Scenes.KorisnikScene.KorisnikMeni;
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

import java.util.List;

public class NapraviAdmina extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Promeni korisnika u admina");
    private Label porukaLabel = new Label("");

    private TableView<Korisnik> tableView = new TableView<>();

    private Button dodajDugme = new Button("Dodaj admina");
    private Button nazadDugme = new Button("Nazad");

    @Override
    public void start(Stage primaryStage) {
        tableView = TabelaUtil.korisniciTabela();
        HBox dugmici = FxUtil.napraviButtonBox(nazadDugme, dodajDugme);
        VBox root = FxUtil.napraviRoot(naslovLabel, tableView, porukaLabel, dugmici);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Napravi admina");
        primaryStage.setScene(scene);
        primaryStage.show();

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new AdminMeni().start(primaryStage);
        });

        dodajDugme.setOnAction(actionEvent -> {
            if (tableView.getSelectionModel().getSelectedItem().isAdmin()) {
                porukaLabel.setText("Korisnik je vec admin");
                porukaLabel.setTextFill(Color.RED);
            } else {
                porukaLabel.setText("Uspesno ste updejtovali korisnika!");
                porukaLabel.setTextFill(Color.GREEN);
                Korisnik korisnik = tableView.getSelectionModel().getSelectedItem();
                korisnik.setAdmin(true);
                KoriniskKontroler.updejtujKorisnika(korisnik);
                List<Korisnik> korisnici = KoriniskKontroler.citajKorisnike();
                tableView.getItems().clear();
                tableView.getItems().addAll(korisnici);
            }
        });

    }
}
