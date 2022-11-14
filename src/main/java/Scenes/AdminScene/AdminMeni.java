package Scenes.AdminScene;

import Scenes.KorisnikScene.KorisnikMeni;
import Scenes.KorisnikScene.NapraviDres;
import Scenes.KorisnikScene.PromeniPodatke;
import Scenes.Login;
import Util.FxUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMeni extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Button dugme1 = new Button("Napravi admina");
    private Button promeniDugme = new Button("Promeni nalog");
    private Button dodajArtikal = new Button("Dodaj artikal");
    private Button obrisiArtikal = new Button("Obrisi artikal");
    private Button logoutDugme = new Button("Izlogujte se");

    @Override
    public void start(Stage primaryStage) {
        HBox dugmici1 = FxUtil.napraviButtonBox(dugme1, dodajArtikal);
        HBox dugmici2 = FxUtil.napraviButtonBox(promeniDugme, obrisiArtikal);
        VBox root = FxUtil.napraviRoot(dugmici1, dugmici2, logoutDugme);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Admin meni");
        primaryStage.setScene(scene);
        primaryStage.show();

        obrisiArtikal.setOnAction(actionEvent -> {
            primaryStage.close();
            new ObrisiArtikal().start(primaryStage);
        });

        dodajArtikal.setOnAction(actionEvent -> {
            primaryStage.close();
            new DodajArtikal().start(primaryStage);
        });

        promeniDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new PromeniPodatke().start(primaryStage);
        });

        dugme1.setOnAction(actionEvent -> {
            primaryStage.close();
            new NapraviAdmina().start(primaryStage);
        });

        logoutDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new Login().start(primaryStage);
        });
    }
}
