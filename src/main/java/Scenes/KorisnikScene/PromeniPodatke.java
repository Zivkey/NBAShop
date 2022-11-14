package Scenes.KorisnikScene;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Korisnik;
import Scenes.AdminScene.AdminMeni;
import Scenes.Login;
import Util.FxUtil;
import Util.GeneralUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class PromeniPodatke extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Promenite podatke");
    private Label usernameLabel = new Label("Promenite username");
    private Label sifraLabel = new Label("Unesite staru sifru");
    private Label novaLabel = new Label("Unesite novu sifru");
    private Label userPoruka = new Label("");
    private Label passwordPorukal = new Label("");

    private Label emptyLabel = new Label();
    private Label emptyLabel2 = new Label();

    private TextField usernameField = new TextField();
    private PasswordField stariField = new PasswordField();
    private PasswordField novaField = new PasswordField();

    private Button userButton = new Button("Promenite username");
    private Button sifraButton = new Button("Promenite sifru");
    private Button nazadDugme = new Button("Nazad");

    @Override
    public void start(Stage primaryStage) {
        userPoruka.setTextFill(Color.RED);
        userPoruka.setVisible(false);
        VBox rootLeft = FxUtil.napraviRoot( usernameLabel, usernameField, userPoruka, userButton, emptyLabel2, emptyLabel);
        VBox rootRight = FxUtil.napraviRoot(sifraLabel, stariField, novaLabel, novaField, passwordPorukal, sifraButton);
        HBox rootKutija = new HBox(rootLeft, rootRight);
        rootKutija.setSpacing(20);
        rootKutija.setAlignment(Pos.CENTER);
        rootKutija.setPadding(new Insets(20));
        VBox root = FxUtil.napraviRoot(naslovLabel, rootKutija, nazadDugme);
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Promeni podatke");
        primaryStage.setScene(scene);
        primaryStage.show();

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            if (Login.getTrenutniKorisnik().isAdmin()) {
                new AdminMeni().start(primaryStage);
            } else {
                new KorisnikMeni().start(primaryStage);
            }
        });

        userButton.setOnAction(actionEvent -> {
            userPoruka.setVisible(true);
            userPoruka.setTextFill(Color.RED);
            if (usernameField.getText().length() < 4) {
                userPoruka.setText("Username mora biti \n duzi od 3 karaktera!");
            } else if (!GeneralUtil.proveriUsername(usernameField.getText())) {
                userPoruka.setText("Username je vec u upotrebi!");
            } else {
                userPoruka.setText("Uspesno se promenili username");
                userPoruka.setTextFill(Color.GREEN);
                Korisnik korisnik = Login.getTrenutniKorisnik();
                korisnik.setUsername(usernameField.getText());
                KoriniskKontroler.updejtujKorisnika(korisnik);
                Login.setTrenutniKorisnik(korisnik);
            }
        });

        sifraButton.setOnAction(actionEvent -> {
            passwordPorukal.setTextFill(Color.RED);
            passwordPorukal.setVisible(true);
            if (!stariField.getText().equals(Login.getTrenutniKorisnik().getSifra())) {
                passwordPorukal.setText("Stara sifra nije u redu!");
            }
            else if (novaField.getText().length() < 4) {
                passwordPorukal.setText("Sifra mora biti duza od 3 karaktera!");
            } else {
                passwordPorukal.setText("Uspesno ste promenili sifru");
                passwordPorukal.setTextFill(Color.GREEN);
                Korisnik korisnik = Login.getTrenutniKorisnik();
                korisnik.setSifra(novaField.getText());
                Login.setTrenutniKorisnik(korisnik);
                KoriniskKontroler.updejtujKorisnika(korisnik);
            }
        });

    }
}
