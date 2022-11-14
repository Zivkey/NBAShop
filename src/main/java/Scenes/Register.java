package Scenes;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Korisnik;
import Util.FxUtil;
import Util.GeneralUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Register extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Registrujte se");
    private Label usernameLabel = new Label("Unesite username");
    private Label imeLabel = new Label("Unesite ime");
    private Label prezimeLabel = new Label("Unesite prezime");
    private Label sifraLabel = new Label("Unesite sifru");

    private Label porukaUsername = new Label("Niste lepo uneli username!");
    private Label porukaIme = new Label("Niste lepo uneli ime");
    private Label porukaPrezime = new Label("Niste lepo uneli prezime");
    private Label porukaSifra = new Label("Niste lepo uneli sifru");
    private Label porukaFinal = new Label("Uspesno ste se prijavili");

    private TextField usernameField = new TextField();
    private TextField imeField = new TextField();
    private TextField prezimeField = new TextField();
    private PasswordField sifraField = new PasswordField();

    private Button registerDugme = new Button("Registrujte se");
    private Button nazadDugme = new Button("Nazad na login");

    @Override
    public void start(Stage primaryStage) {
        List<Label> poruke = Arrays.asList(porukaSifra, porukaUsername, porukaPrezime, porukaIme);
        for (Label x : poruke) {
            x.setVisible(false);
            x.setTextFill(Color.RED);
        }
        porukaFinal.setVisible(false);
        porukaFinal.setTextFill(Color.GREEN);
        VBox root = FxUtil.napraviRoot(naslovLabel, usernameLabel, usernameField, porukaUsername, imeLabel, imeField, porukaIme, prezimeLabel,
                prezimeField, porukaPrezime, sifraLabel, sifraField, porukaSifra, porukaFinal, registerDugme, nazadDugme);
        Scene scene = new Scene(root, 400, 600);
        root.setSpacing(12);
        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);
        primaryStage.show();

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new Login().start(primaryStage);
        });

        registerDugme.setOnAction(actionEvent -> {
            int brojilac = 0;
            for (Label x : poruke) {
                x.setVisible(false);
            }
            porukaFinal.setVisible(false);
            if (!GeneralUtil.proveriUsername(usernameField.getText()) || usernameField.getText().length() < 3) {
                brojilac += 1;
                porukaUsername.setVisible(true);
            }
            if (!GeneralUtil.samoSlova(imeField.getText()) || imeField.getText().length() < 3) {
                brojilac += 1;
                porukaIme.setVisible(true);
            }
            if (!GeneralUtil.samoSlova(prezimeField.getText()) || prezimeField.getText().length() < 3) {
                brojilac += 1;
                porukaPrezime.setVisible(true);
            }
            if (sifraField.getText().length() < 5) {
                brojilac += 1;
                porukaSifra.setVisible(true);
            }
            if (brojilac == 0) {
                Korisnik korisnik = new Korisnik(usernameField.getText(), imeField.getText(), prezimeField.getText(), sifraField.getText(),
                        false, 0);
                KoriniskKontroler.dodajKorisnika(korisnik);
                porukaFinal.setVisible(true);
                usernameField.setText("");
                imeField.setText("");
                prezimeField.setText("");
                sifraField.setText("");
            }
        });
    }
}
