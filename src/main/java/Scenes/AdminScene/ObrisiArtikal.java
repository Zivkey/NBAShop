package Scenes.AdminScene;

import BazaPodataka.ArtikalKontroler;
import Entiteti.Artikal;
import Util.FxUtil;
import Util.TabelaUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class ObrisiArtikal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Obrisi artikal");
    private Label porukaLabel = new Label("Uspesno ste obrisali artikal");

    private TableView<Artikal> tableViewa = new TableView<>();

    private Button obrisiDugme = new Button("Obrisi");
    private Button nazadDugme = new Button("Nazad");

    @Override
    public void start(Stage primaryStage) {
        porukaLabel.setVisible(false);
        porukaLabel.setTextFill(Color.GREEN);
        tableViewa = TabelaUtil.artikliTabela();
        VBox root = FxUtil.napraviRoot(naslovLabel, tableViewa, porukaLabel, obrisiDugme, nazadDugme);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Obrisi artikal");
        primaryStage.setScene(scene);
        primaryStage.show();

        nazadDugme.setOnAction(actionEvent -> {
            primaryStage.close();
            new AdminMeni().start(primaryStage);
        });

        obrisiDugme.setOnAction(actionEvent -> {
            Artikal a = tableViewa.getSelectionModel().getSelectedItem();
            ArtikalKontroler.obrisiArtikal(a);
            tableViewa.getItems().clear();
            tableViewa.getItems().addAll(ArtikalKontroler.citajArtikle());
            porukaLabel.setVisible(true);
        });
    }
}
