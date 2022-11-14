package Scenes;

import BazaPodataka.KoriniskKontroler;
import Entiteti.Korisnik;
import Scenes.AdminScene.AdminMeni;
import Scenes.KorisnikScene.KorisnikMeni;
import Util.FxUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Ulogujte se na vas nalog");
    private Label usernameLabel = new Label("Unesite username:");
    private Label sifraLabel = new Label("Unesite sifru");
    private Label porukaLabel = new Label("");


    private TextField usernameField = new TextField();
    private PasswordField sifraField = new PasswordField();

    private Button loginDugme = new Button("Ulogujte se");
    private Button registerDugme = new Button("Registrujte se");

    private static Korisnik trenutniKorisnik;


    public static Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public static void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        Login.trenutniKorisnik = trenutniKorisnik;
    }

    @Override
    public void start(Stage primaryStage) {
        List<Korisnik> korisnici = KoriniskKontroler.citajKorisnike();
        HBox dugmeBox = FxUtil.napraviButtonBox(loginDugme, registerDugme);
        VBox root = FxUtil.napraviRoot(naslovLabel, usernameLabel, usernameField, sifraLabel, sifraField, porukaLabel, dugmeBox);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        registerDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new Register().start(primaryStage);
        });

        loginDugme.setOnAction(actionEvent -> {
            String username = usernameField.getText();
            String sifra = sifraField.getText();
            for (Korisnik x : korisnici) {
                if (x.getUsername().equalsIgnoreCase(username) && x.getSifra().equals(sifra)) {
                    if (x.isAdmin()) {
                        Login.setTrenutniKorisnik(x);
                        primaryStage.close();
                        new AdminMeni().start(primaryStage);
                    } else {
                        Login.setTrenutniKorisnik(x);
                        primaryStage.close();
                        new KorisnikMeni().start(primaryStage);
                    }
                }
            }
            porukaLabel.setText("Niste lepo uneli username ili sifru!");
            porukaLabel.setTextFill(Color.RED);

        });


    }
}
