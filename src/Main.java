import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath="C:\\Users\\l0860\\Downloads\\dane_2\\dane_2\\przyklad.txt";
        ArrayList<String>liczbySt=Download(filepath);
        ArrayList<Integer>liczbyint=Tointarraylist(liczbySt);
        for(String i:zad61(liczbyint)){
            System.out.println(i);
        }
    for(String i:zad62(liczbySt))
        System.out.println(i);
    }

    private static ArrayList<String> Download(String filepath) {
        ArrayList<String>Wynik=new ArrayList<>();
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
    public static ArrayList<Integer> Tointarraylist(ArrayList<String>linijki){
        ArrayList<Integer>wynik=new ArrayList<>();
        String []liczby;
        for(String i: linijki ){
           liczby=i.split(" ");
           for(String j:liczby){
               wynik.add(Integer.parseInt(j));
           }
        }
     return wynik;
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
   public static ArrayList<String> zad62(ArrayList<String>linijki){
        ArrayList<String>Wynik=new ArrayList<>();
        int liniki_do_usuniecia=0;
       for(String i: linijki){
           String[]liczby=i.split(" ");
           for(int j=0 ;j<liczby.length;j++){
               if(!(liczby[j].equals(liczby[319-j]))){
                   liniki_do_usuniecia++;
                   break;
               }
           }
       }
       Wynik.add("Liniji do usunięcia");
       Wynik.add(Integer.toString(liniki_do_usuniecia));
       return Wynik;
    }
}
        
    
