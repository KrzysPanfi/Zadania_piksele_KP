import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test61 {

    @Test
    void zad61() {
        String filepath = "C:\\Users\\PC\\Downloads\\dane_2\\dane_2\\przyklad.txt";
        ArrayList<String> linie = Main.Download(filepath);
        if (linie == null) {
            System.out.println("Błąd wczytywania pliku");
        } else {
            ArrayList<Integer> liczbyint = Main.Tointarraylist(linie);
            ArrayList<String> wynik = Main.zad61(liczbyint);
            boolean wynik1=false;
            if(Integer.parseInt(wynik.get(1))==255&&Integer.parseInt(wynik.get(3))==0){
                wynik1=true;
            }
           assertTrue(wynik1);
        }

    }
}