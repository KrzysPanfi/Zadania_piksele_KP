import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Testzads62 {

    @Test
    void zad62() {
        String filepath = "C:\\Users\\PC\\Downloads\\dane_2\\dane_2\\przyklad.txt";
        ArrayList<String> linie = Main.Download(filepath);
        if (linie == null) {
            System.out.println("Błąd wczytywania pliku");
        } else {
            assertEquals(3,Integer.parseInt(Main.zad62(linie).get(1)));
        }
    }
}