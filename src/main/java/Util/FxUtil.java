package Util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FxUtil {
    /**
     * Metoda koja automatski dodaje sve elemente u Vbox i njemu daje atribute
     * @param nodes svi atributi koje dodajemo
     * @return smesteni atributi u Vbox
     */
    public static VBox napraviRoot(Node... nodes) {
        VBox root = new VBox();
        for (Node x : nodes) {
            root.getChildren().add(x);
            if (x instanceof TextField) {
                ((TextField) x).setMaxWidth(150);
            }
        }
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        return root;
    }

    /**
     * Metoda koja pravi buttonBox od svih dugmica koje joj prosledimo
     * @param buttons dugmici od kojih zelimo da napravimo Hbox
     * @return Hbox sa rasporedjenim dugmicima
     */
    public static HBox napraviButtonBox(Button... buttons) {
        HBox newBox = new HBox();
        for (Button x : buttons) {
            x.setMaxWidth(120);
            x.setMinWidth(120);
            newBox.getChildren().add(x);
        }
        newBox.setSpacing(20);
        newBox.setAlignment(Pos.CENTER);
        newBox.setPadding(new Insets(10));
        return newBox;
    }
}
