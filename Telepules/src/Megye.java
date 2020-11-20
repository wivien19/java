import com.sun.jdi.DoubleValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Megye {
    private String nev;
    private List<Telepules> telepulesek;
    private String web = "";

    public Megye(String nev) {
        this.nev = nev;
        this.telepulesek = new ArrayList<>();
    }

    public boolean ujTelepules(String var1) {
        int var2 = 0;
        boolean var3 = false;

        for(int var4 = 0; var4 < var1.length(); ++var4) {
            if (var1.charAt(var4) == ':') {
                ++var2;
            }
        }

        if (var2 > 1) {
            var3 = true;
            String[] var8 = var1.split(":");

            Telepules var5;
            try {
                var5 = new Telepules(var8[0], Double.valueOf(var8[1]));
                var5.emailFrissitese(var8[2]);
            } catch (TelepuleskezeloException var7) {
                var5 = null;
                var3 = false;
            }

            if (var3) {
                this.telepulesek.add(var5);
            }

            return var3;
        } else {
            return var3;
        }
    }
        public void webcimFrissites (String param){

            if ((param.toLowerCase().contains(nev.toLowerCase()))) {
                this.web = param;

            } else {
                throw new IllegalArgumentException("Hibas webcim: " + param);
            }
        }
    public void ujLakok(int var1, String var2, int var3) {
        if (var1 < this.telepulesek.size() && var1 >= 0) {
            try {
                ((Telepules)this.telepulesek.get(var1)).ujLakok(var2, var3);
            } catch (TelepuleskezeloException var5) {
                throw new IllegalArgumentException(((Telepules)this.telepulesek.get(var1)).getNev() + " varosban nem letezik a megadott kerulet!", var5);
            }
        } else {
            throw new IllegalArgumentException("Nem letezik a megadott indexu varos!");
        }
    }
        public int keres (String param){
            int szamlalo = 0;
            for (int i = 0; i < this.telepulesek.size(); ++i) {
                if (((Telepules) this.telepulesek.get(i)).getNev().contains(param)) {
                    szamlalo++;
                }
            }
            return szamlalo;
        }
        public int lakossag () {
            int szam = 0;
            for (int i = 0; i < this.telepulesek.size(); i++) {
                szam += ((Telepules) this.telepulesek.get(i)).getLakosokSzama();
            }
            return szam;
        }

        @Override
        public String toString () {
            return this.nev + " megye (" + this.web + ")";
        }

    }

