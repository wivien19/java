import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kurzus {
    private String kurzuskod;
    private String nev;
    private int maxpont;
    private int kreditertek;
    private OsztalyozasiMod osztalyozasiMod;

    public String getKurzuskod() {
        return kurzuskod;
    }

    public String getNev() {
        return nev;
    }

    public int getMaxpont() {
        return maxpont;
    }

    public int getKreditertek() {
        return kreditertek;
    }

    public OsztalyozasiMod getOsztalyozasiMod() {
        return osztalyozasiMod;
    }

    public Kurzus(String kurzuskod, String nev, int maxpont, OsztalyozasiMod osztalyozasiMod, int kreditertek) {
        this.kurzuskod = kurzuskod;
        this.nev = nev;
        this.maxpont = maxpont;
        this.kreditertek = kreditertek;
        this.osztalyozasiMod = osztalyozasiMod;
    }
    public static Kurzus beolvas (String filename) {

        String[] param=new String[4];
        String line2 = "";
        try ( Scanner sc= new Scanner(new File(filename)) ){
            String line1 = sc.nextLine();
            param=line1.split(";");

            line2 = sc.nextLine();


        } catch (NullPointerException | FileNotFoundException e) {
            e.printStackTrace();


        }
        return new Kurzus(param[0], param[1], Integer.parseInt(param[2]), OsztalyozasiMod.beolvas(line2) , Integer.parseInt(param[3]));

    }

    @Override
    public String toString() {
        return kurzuskod;
    }
}
