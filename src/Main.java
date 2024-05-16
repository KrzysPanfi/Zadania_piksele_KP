import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\PC\\Downloads\\dane_2\\dane_2\\dane.txt";
        ArrayList<String> liczbySt = Download(filepath);
        if(liczbySt==null){
            System.out.println("Błąd wczytywania pliku");
        }
        else {
            ArrayList<Integer> liczbyint = Tointarraylist(liczbySt);
            int[][] img = To2darray(liczbySt);
            for (String i : zad61(liczbyint)) {
                System.out.println(i);
            }
            for (String i : zad62(liczbySt))
                System.out.println(i);

            for (String i : zad63(img))
                System.out.println(i);
            for (String i : zad64(img))
                System.out.println(i);
        }
    }

    private static ArrayList<String> Download(String filepath) {
        ArrayList<String> Wynik = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Wynik.add(line);
            }

            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public static int[][] To2darray(ArrayList<String> linijki) {
        int[][] img = new int[200][320];
        for (int i = 0; i < 200; i++) {
            String[] liczby = linijki.get(i).split(" ");
            for (int j = 0; j < 320; j++) {
                img[i][j] = Integer.parseInt(liczby[j]);
            }
        }
        return img;
    }
    public static ArrayList<Integer> Tointarraylist(ArrayList<String> linijki) {
        ArrayList<Integer> wynik = new ArrayList<>();
        String[] liczby;
        for (String i : linijki) {
            liczby = i.split(" ");
            for (String j : liczby) {
                wynik.add(Integer.parseInt(j));
            }
        }
        return wynik;
    }

    public static ArrayList<String> zad61(ArrayList<Integer> Lista) {
        ArrayList<String> wynik = new ArrayList<>();
        wynik.add("Najjaśniejszy");
        int brightest = 0;
        int darkest = Integer.MAX_VALUE;
        for (int i : Lista) {
            if (i > brightest) {
                brightest = i;
            } else if (i < darkest) {
                darkest = i;
            }
        }
        wynik.add(Integer.toString(brightest));
        wynik.add("Najciemniejszy");
        wynik.add(Integer.toString(darkest));
        return wynik;
    }

    public static ArrayList<String> zad62(ArrayList<String> linijki) {
        ArrayList<String> Wynik = new ArrayList<>();
        int liniki_do_usuniecia = 0;
        for (String i : linijki) {
            String[] liczby = i.split(" ");
            for (int j = 0; j < liczby.length; j++) {
                if (!(liczby[j].equals(liczby[319 - j]))) {
                    liniki_do_usuniecia++;
                    break;
                }
            }
        }
        Wynik.add("Linijki do usunięcia");
        Wynik.add(Integer.toString(liniki_do_usuniecia));
        return Wynik;
    }

    public static ArrayList<String> zad63(int[][] img) {
        ArrayList<String> Wynik = new ArrayList<>();
        int count = 0;

        for (int x = 0; x < 200; x++) {
            for (int y = 0; y < 320; y++) {
                ArrayList<Integer[]> near = new ArrayList<>();
                    if (x != 0)
                        near.add(new Integer[]{x - 1, y});
                    if (x != 199)
                        near.add(new Integer[]{x + 1, y});
                    if (y != 0)
                        near.add(new Integer[]{x, y - 1});
                    if (y != 319)
                        near.add(new Integer[]{x, y + 1});

                int c = 0;
                for (Integer[] points : near) {
                    if (Math.abs(img[x][y] - img[points[0]][points[1]]) > 128) {
                        c++;
                    }

                }
                if (c > 0) {
                    count++;
                }

            }
        }
        Wynik.add("Kontrastujące");
        Wynik.add(Integer.toString(count));
        return Wynik;
    }

    public static ArrayList<String> zad64(int[][] img) {
        ArrayList<String> Wynik = new ArrayList<>();
        int tmp = 0;
        for (int i = 1; i < 320; i++) {
            int c = 0;
            int cmax = 0;
            for (int j = 1; j < 200; j++) {
                if (img[j][i] == img[j-1][i]) {
                    c++;
                } else {
                    if (c > cmax) {
                        cmax = ++c;

                    }
                    c = 0;
                }
                if (tmp < cmax) {
                    tmp = cmax;
                }
            }
        }

            Wynik.add("Najdluzsza kolumna");
            Wynik.add(Integer.toString(tmp));
            return Wynik;

        }

}
        
    
