package Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupUtil {
    /**
     * Metoda koja preko jsoupa cita sve NBA timove i dodaje ih u listu
     * @return listu svih nba timova
     */
    public static List<String> jsoupLista() {
        List<String> lista = new ArrayList<>();
        try {
            Document document = Jsoup.connect("https://www.hoopsbeast.com/list-of-nba-teams/").get();
            Elements e = document.body().select("li");
            for (int i = 0; i < e.size(); i++) {
                if (i > 3 && i < 34) {
                    String tim = e.get(i).text();
                    lista.add(tim);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
