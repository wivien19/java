import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public final class Hallgato {
    private String nev;
    private String neptun;
  private Map<String, Set<Teljesites>> teljesitesek = new HashMap<>();
    public Hallgato(String nev, String neptun) throws IllegalArgumentException{
        this.nev = nev;
        if (neptun.length()==6){
            for (int i =0; i<neptun.length();i++){
                if ((neptun.charAt(i)<='9' && neptun.charAt(i)>='0' )|| (neptun.charAt(i)>='A' && neptun.charAt(i) <= 'Z')){
                    this.neptun = neptun;
                }
                else {
                    throw new IllegalArgumentException("hibas neptun kod");
                }
            }
        }
        else {
            throw new IllegalArgumentException("hibas neptun kod");
        }


    }

    public void beiratkozik(String felev){

        if ( teljesitesek.containsKey(felev)) {
            System.err.println("nem lehet tobbszor beiratkozni");
        }
        else {
            teljesitesek.put(felev, new HashSet<>());
        }
    }
    public void teljesiteseketFelvesz(String filename){

        try( Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line1 = sc.nextLine();
                String[] param = line1.split(";");

                Teljesites obj = new Teljesites(Kurzus.beolvas(param[0]), Integer.parseInt(param[1]));
                String[] nevem = filename.split(".txt");
                teljesitesek.get(nevem[0]).add(obj);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public int bukas(){
        int szamlalo=0;
     for (Set<Teljesites> teljesites : teljesitesek.values()){
         for (Teljesites teljesites1 : teljesites){
             if (teljesites1.erdemjegy()==1)
                 szamlalo++;
         }
     }
        return szamlalo;
    }
    public void felvettKurzusok(String felev, String fajlnev){

        try(PrintWriter pw = new PrintWriter(new File(fajlnev))) {
           Set<Teljesites> telj = teljesitesek.get(felev);
           for (Teljesites te : telj){
               pw.println(te.getKurzus().getNev());
           }
        } catch (NullPointerException |FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void katasztrofa(String filename){
        new File(filename);
        int szamlalo=0;
        int max=0;
        int akt=0;
        ArrayList<Integer> szam = new ArrayList<>();
        String fel = "";

        try(PrintWriter print = new PrintWriter(new  File(filename))) {
                for (Map.Entry<String, Set<Teljesites>> telj: teljesitesek.entrySet()) {
                    szamlalo=0;
                        for (Teljesites teljesites1 : telj.getValue()) {
                            if (teljesites1.erdemjegy() == 1) {
                                szamlalo++;

                            }
                        }

                        if (szamlalo>=max){
                            max=szamlalo;
                            fel=telj.getKey();
                            szam.add(max);
                        }
                    }
                for (int a : szam){
                    if (a == max && max!=0){
                        akt++;
                    }
                }
            if (akt==0){
                print.println("mindent teljesitett" );
            }
            else if (akt>=2){
                print.println("tobb ilyen felev is van");
            }
            else if (akt==1){
                print.println(fel);
            }
                /*todo teljes katasztrófa*/



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public double diplomaatlag(){
        double atlag=0.0;
        double kred=0.0;
       for (Set<Teljesites> teljesites: teljesitesek.values()){
           for (Teljesites teljesites1: teljesites){
               atlag+=teljesites1.kurzus.getKreditertek()*teljesites1.erdemjegy();
               kred+=teljesites1.kurzus.getKreditertek();
           }

            }

        return atlag/kred;
    }


    public String getNev() {
        return nev;
    }

    public String getNeptun() {
        return neptun;
    }

    public Map<String, Set<Teljesites>> getTeljesitesek() {
        return teljesitesek;
    }
}
