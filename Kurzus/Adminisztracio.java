import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Adminisztracio {
    public void tomegesKatasztrofa (List<Hallgato> hallgatok, String mappa){
      File f=   new File(mappa);
        f.mkdirs();
        for ( Hallgato hallgatoes : hallgatok){
            hallgatoes.katasztrofa(mappa+"/"+(hallgatoes.getNeptun()+".student"));
        }

    }
    public List<Hallgato> hallgatokatFelvesz(String filename){
        List<Hallgato> valami = new ArrayList<>();
        int jelenlegiPont = 0;
        try(Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] darabok = sor.split("-");
                if ("pontszam".equals(darabok[0])){
                    jelenlegiPont = Integer.parseInt(darabok[1]);

                }
                else if ("hallgato".equals(darabok[0])){
                    if (Integer.parseInt(darabok[3])>=jelenlegiPont){
                        valami.add(new Hallgato(darabok[1], darabok[2]));
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return valami;
    }
    public static    double atlag = 0.0;
    public static   String nev = "";
    private static String listaz(File file) {
        if (file.isDirectory()) {
            File[] fajlok = file.listFiles();

            for (File f : fajlok) {
                listaz(f);
            }
        } else {
            if (file.getName().endsWith(".student")) {
                try (Scanner sc = new Scanner(file)){
                    String sor = sc.nextLine();

                    String[] val = sor.split(",");
                    StringJoiner sj = new StringJoiner(".");
                    sj.add(val[0]);
                    sj.add(val[1]);
                    if (atlag < Double.parseDouble(String.valueOf(sj))) {
                        atlag = Double.parseDouble(String.valueOf(sj));
                        String[] lname = file.getName().split(".student");
                        nev = lname[0];
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } return nev + ";" + atlag;
    }
    public void legjobbHallgato(String mappa){

       File uj=  new File(mappa);
       new File("legjobbhallgato.txt");
        try(PrintWriter pw = new PrintWriter(mappa+"/"+"legjobbhallgato.txt")) {
            pw.print(listaz(uj));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
