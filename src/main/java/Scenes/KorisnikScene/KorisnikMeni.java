package Scenes.KorisnikScene;

import Scenes.Login;
import Util.FxUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KorisnikMeni extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Dobro dosli " + Login.getTrenutniKorisnik().getIme() + " " + Login.getTrenutniKorisnik().getPrezime());
    private Label stanjeLabel = new Label("Stanje na racunu: " + Login.getTrenutniKorisnik().getNovac() + " rsd.");
    private Button napraviDugme = new Button("Napravi dres");
    private Button promeniDugme = new Button("Promeni nalog");
    private Button uplataDugme = new Button("Uplatite novac");
    private Button kupiArtikal = new Button("Kupite artikal");
    private Button logoutDugme = new Button("Izlogujte se");

    @Override
    public void start(Stage primaryStage) {
        HBox dugmici1 = FxUtil.napraviButtonBox(napraviDugme, promeniDugme);
        HBox dugmici2 = FxUtil.napraviButtonBox(uplataDugme, kupiArtikal);
        VBox root = FxUtil.napraviRoot(naslovLabel, stanjeLabel, dugmici1, dugmici2, logoutDugme);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Meni");
        primaryStage.setScene(scene);
        primaryStage.show();

        promeniDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new PromeniPodatke().start(primaryStage);
        });

        napraviDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new NapraviDres().start(primaryStage);
        });

        uplataDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new UplatiteNovac().start(primaryStage);
        });

        kupiArtikal.setOnAction(actionEvent -> {
            primaryStage.close();
            new KupiArtikal().start(primaryStage);
        });

        logoutDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new Login().start(primaryStage);
        });
    }
}
