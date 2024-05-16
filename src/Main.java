import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath="C:\\Users\\l0860\\Downloads\\dane_2\\dane_2\\przyklad.txt";
        ArrayList<Integer>liczby=Download(filepath);
        for(String i:zad61(liczby)){
            System.out.println(i);
        }



    }

    private static ArrayList<Integer> Download(String filepath) {
        ArrayList<Integer>Wynik=new ArrayList<>();
        try {



            FileReader fileReader = new FileReader(filepath);



            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;



            while ((line = bufferedReader.readLine()) != null) {
                String[]liczby=line.split(" ");
                for(String i:liczby){
                    Wynik.add(Integer.parseInt(i));
                }

            }

            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
    public static ArrayList<String> zad61 (ArrayList<Integer>Lista){
        ArrayList<String> wynik=new ArrayList<>();
        wynik.add("Najaśniejsza");
        int brightest=0;
        int darkest=Integer.MAX_VALUE;
        for(int i:Lista){
            if(i>brightest){
                brightest=i;
            }
            else if (i<darkest){
                darkest=i;
            }
        }
        wynik.add(Integer.toString(brightest));
        wynik.add("Najciemniejszy");
        wynik.add(Integer.toString(darkest));
        return wynik;
    }
    public static ArrayList<String> zad62(ArrayList<Integer>lista){
        
    }
}
        
    
