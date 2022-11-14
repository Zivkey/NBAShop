package Scenes.AdminScene;

import BazaPodataka.ArtikalKontroler;
import Entiteti.Artikal;
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

public class DodajArtikal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Dodaj artikal");
    private Label imeLabel = new Label("Unesi ime artikla");
    private Label tipLabel = new Label("Unesi tip artikla");
    private Label cenaLabel = new Label("Unesi cenu artikla");
    private Label porukaLabel = new Label("");

    private TextField imeField = new TextField();
    private TextField tipField = new TextField();
    private TextField cenaField = new TextField();

    private Button nazadDugme = new Button("Nazad");
    private Button dodajDugme = new Button("Dodaj");

    @Override
    public void start(Stage primaryStage) {

        HBox dugmici = FxUtil.napraviButtonBox(nazadDugme, dodajDugme);
        VBox root = FxUtil.napraviRoot(naslovLabel, imeLabel, imeField, tipLabel, tipField, cenaLabel, cenaField, porukaLabel, dugmici);
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setTitle("Dodaj artikal");
        primaryStage.setScene(scene);
        primaryStage.show();

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new AdminMeni().start(primaryStage);
        });

        dodajDugme.setOnAction(actionEvent -> {
            porukaLabel.setTextFill(Color.RED);
            if (!GeneralUtil.samoCifre(cenaField.getText())) {
                porukaLabel.setText("Cena mora biti broj");
            } else if (imeField.getText().length() < 4 || tipField.getText().length() < 4) {
                porukaLabel.setText("Ime i tip nisu validni");
            } else {
                Artikal artikal = new Artikal(imeField.getText(), tipField.getText(), Integer.parseInt(cenaField.getText()));
                ArtikalKontroler.dodajArtikal(artikal);
                porukaLabel.setText("Artikal je uspesno dodat!");
                porukaLabel.setTextFill(Color.GREEN);
            }
        });

    }
}
