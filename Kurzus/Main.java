import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Hallgato h1 = new Hallgato("LLLL", "AAAZ09");
      /*  Map<String, Set<Teljesites>> teljesitesek = new HashMap<>();
        for (Set<Teljesites> teljesites : teljesitesek.values()){
            for (Teljesites teljesites1 : teljesites ){
                OsztalyozasiMod uj = new OsztalyozasiMod(10,20,30,40);
                Kurzus valami = new Kurzus("valami", "hex", 13, uj, 3);;
                teljesites1 = new Teljesites(valami, 1600);
                teljesites.add(teljesites1);
                teljesitesek.put("2019", teljesites);
            }
        }
*/


/*
        System.out.println(h1.bukas());
        System.out.println(h1.getTeljesitesek().values().size());
        System.out.println(h1.getTeljesitesek().get(0));

       //h1.felvettKurzusok();
        System.out.println(h1.getNeptun());*/
        Adminisztracio valami = new Adminisztracio();
        valami.legjobbHallgato("valami");

  /*     h1.beiratkozik("2019");
        System.out.println(teljesitesek);

        //System.out.println(h1.getTeljesitesek().values());
*/



    }


}
