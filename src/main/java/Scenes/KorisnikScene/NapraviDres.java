package Scenes.KorisnikScene;

import BazaPodataka.DresKontroler;
import BazaPodataka.KoriniskKontroler;
import Entiteti.Dres;
import Entiteti.Korisnik;
import Scenes.Login;
import Util.FxUtil;
import Util.GeneralUtil;
import Util.JsoupUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NapraviDres extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Napravite vas dres, cena dresa je 3500 dinara");
    private Label imeLabel = new Label("Napisiste ime koje zelite da bude na dresu");
    private Label brojLabel = new Label("Odaberite broj koji zelite da bude na dresu (Od 0 do 99)");
    private Label klubLabel = new Label("Odaberite klub ciji zelite da bude dres");
    private Label stanjeLabel = new Label("Vase stanje na racunu je " + Login.getTrenutniKorisnik().getNovac() + " rsd.");
    private Label porukaLabel = new Label();

    private TextField imeField = new TextField();
    private TextField brojField = new TextField();
    private ComboBox<String> klubCombo = new ComboBox<>();

    private Button napraviDugme = new Button("Napravi dres");
    private Button backDugme = new Button("Nazad");

    @Override
    public void start(Stage primaryStage) {
        //List<String> klubovi = JsoupUtil.jsoupLista();
        List<String> klubovi = Arrays.asList("Lakers", "GoldenState", "Bulls");
        klubCombo.getItems().addAll(klubovi);
        klubCombo.getSelectionModel().selectFirst();
        HBox dugmici = FxUtil.napraviButtonBox(backDugme, napraviDugme);
        VBox root = FxUtil.napraviRoot(naslovLabel, stanjeLabel, imeLabel, imeField, brojLabel, brojField, klubLabel, klubCombo, porukaLabel, dugmici);
        Scene scene = new Scene(root, 400, 450);
        primaryStage.setTitle("Napravi dres");
        primaryStage.setScene(scene);
        primaryStage.show();

        backDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new KorisnikMeni().start(primaryStage);
        });

        napraviDugme.setOnAction(actionEvent -> {
            if (brojField.getText().length() == 0 || imeField.getText().length() == 0) {
                porukaLabel.setText("Niste uneli sve podatke");
                porukaLabel.setTextFill(Color.RED);
            } else if (!GeneralUtil.samoSlova(imeField.getText())) {
              porukaLabel.setText("Niste lepo uneli ime");
              porukaLabel.setTextFill(Color.RED);
            } else if (!GeneralUtil.samoCifre(brojField.getText())) {
                porukaLabel.setText("Broj nije lepo unet");
                porukaLabel.setTextFill(Color.RED);
            } else if (Integer.parseInt(brojField.getText()) > 99 || Integer.parseInt(brojField.getText()) < 0) {
                porukaLabel.setText("Broj koji je unet nije validan");
                porukaLabel.setTextFill(Color.RED);
            } else if (Login.getTrenutniKorisnik().getNovac() < 3500) {
                porukaLabel.setText("Nema dovoljno novca za dres!");
                porukaLabel.setTextFill(Color.RED);
            } else {
                Dres dres = new Dres(Login.getTrenutniKorisnik(), Integer.parseInt(brojField.getText()), imeField.getText(), klubCombo.getSelectionModel().getSelectedItem());
                DresKontroler.dodajDres(dres);
                Korisnik korisnik = Login.getTrenutniKorisnik();
                korisnik.setNovac(korisnik.getNovac() - 3500);
                KoriniskKontroler.updejtujKorisnika(korisnik);
                Login.setTrenutniKorisnik(korisnik);
                stanjeLabel.setText("Vase stanje na racunu je " + Login.getTrenutniKorisnik().getNovac() + " rsd.");
                porukaLabel.setTextFill(Color.GREEN);
                porukaLabel.setText("Uspesno ste napravili dres");
                imeField.setText("");
                brojField.setText("");

            }
        });

    }
}
