module com.example.matejastojkovicprojektnizadatak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jsoup;


    opens Scenes to javafx.fxml;
    exports Scenes;
    opens Scenes.KorisnikScene to javafx.fxml;
    exports Scenes.KorisnikScene;
    exports Entiteti;
}