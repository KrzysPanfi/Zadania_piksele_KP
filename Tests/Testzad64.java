import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Testzad64 {

    @Test
    void zad64() {
        String filepath = "C:\\Users\\PC\\Downloads\\dane_2\\dane_2\\przyklad.txt";
        ArrayList<String> linie = Main.Download(filepath);
        if (linie == null) {
            System.out.println("Błąd wczytywania pliku");
        } else {
            int[][] img = Main.To2darray(linie);
            assertEquals(198,Integer.parseInt(Main.zad64(img).get(1)));
        }
    }
}