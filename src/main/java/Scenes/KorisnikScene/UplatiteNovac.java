package Scenes.KorisnikScene;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Korisnik;
import Scenes.Login;
import Util.FxUtil;
import Util.GeneralUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UplatiteNovac extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Uplatite novac na vas nalog");
    private Label stanjeLabel = new Label("Trenutno stanje: " + Login.getTrenutniKorisnik().getNovac());
    private Label uplataLabel = new Label("Uplatite novac:");
    private Label porukaUplata = new Label("");

    private TextField uplataField = new TextField();
    private Button uplataDugme = new Button("Uplatite");
    private Button nazadDugme = new Button("Nazad");


    @Override
    public void start(Stage primaryStage) {
        HBox dugmicic = FxUtil.napraviButtonBox(nazadDugme, uplataDugme);
        VBox root = FxUtil.napraviRoot(naslovLabel, uplataLabel, uplataField, stanjeLabel, porukaUplata, dugmicic);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Uplata novca");
        primaryStage.setScene(scene);
        primaryStage.show();

        uplataDugme.setOnAction(actionEvent -> {
            if (GeneralUtil.samoCifre(uplataField.getText())) {
                Korisnik noviKorinik = Login.getTrenutniKorisnik();
                noviKorinik.setNovac(noviKorinik.getNovac() + Integer.parseInt(uplataField.getText()));
                Login.setTrenutniKorisnik(noviKorinik);
                KoriniskKontroler.updejtujKorisnika(noviKorinik);
                porukaUplata.setTextFill(Color.GREEN);
                porukaUplata.setText("Novac uspesno uplacen");
                stanjeLabel.setText("Trenutno stanje: " + Login.getTrenutniKorisnik().getNovac());
            } else {
                porukaUplata.setText("Niste lepo uneli novac!");
                porukaUplata.setTextFill(Color.RED);
            }
        });

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new KorisnikMeni().start(primaryStage);
        });
    }
}
