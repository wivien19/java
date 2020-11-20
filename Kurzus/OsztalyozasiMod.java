import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OsztalyozasiMod {
    private final int erdemjegyek[];

    public OsztalyozasiMod(int kettes, int harmas, int negyes, int otos) {
        this.erdemjegyek = new int[]{kettes, harmas, negyes, otos};
    }


    public int erdemjegy(int pont){
        int jegy=1;
        for (int i=0; i<erdemjegyek.length;i++){
            if (pont>=erdemjegyek[i]){
                jegy++;
            }
        }
        return jegy;
    }
    public static OsztalyozasiMod beolvas(String filename){
        OsztalyozasiMod obj;
        int egy=0;
        int[] tomb=new int[4];
        int ketto=0;
        int harom=0;
        int negy=0;
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()){
                String sor = sc.nextLine();
               tomb[egy]=Integer.parseInt(sor);
                egy++;
            }
    /*            String sor = sc.nextLine();
                egy=Integer.parseInt(sor);
                String sor2 = sc.nextLine();
                ketto=Integer.parseInt(sor2);
            String sor3 = sc.nextLine();
            harom=Integer.parseInt(sor3);
            String sor4 = sc.nextLine();
            negy=Integer.parseInt(sor4);*/


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        obj= new OsztalyozasiMod(tomb[0], tomb[1], tomb[2], tomb[3]);
        return obj;
    }

    public int[] getErdemjegyek() {
        return erdemjegyek;
    }
}
