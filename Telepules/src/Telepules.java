import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Telepules extends Exception {
    private String nev;
    private double terulet;
    private List<Kerulet> keruletek = new ArrayList<Kerulet>();
    private String email;

    public String getNev() {
        return nev;
    }

    public double getTerulet() {
        return terulet;
    }

    public String getEmail() {
        return email;
    }

    public void setTerulet(double terulet) {
        if (terulet <= 0) {
            this.terulet = 1;
        } else {
            this.terulet = terulet;
        }

    }

    public Telepules(String nev, double terulet) throws IllegalArgumentException {
        //idea alapján ok
        email = null;
        if (nev.charAt(0) > 'Z') {
            throw new IllegalArgumentException("Hibas varosnev: " + nev);
        } else {
            this.nev = nev;
        }
        if (terulet <= 0) {
            this.terulet = 1;
        } else {
            this.terulet = terulet;
        }
    }

    public void emailFrissitese(String param) throws TelepuleskezeloException {
        //idea alapján ok
        int szamlalo = 0;
        Telepules obj = new Telepules(nev, terulet);
        if (param.endsWith(".hu") && param.startsWith("info") && param.contains("@")) {
            for (int i = 0; i < param.length(); i++) {
                if (param.charAt(i) == '@') {
                    szamlalo++;
                }
            }
            if (!(szamlalo == 1)) {
                throw new TelepuleskezeloException(obj, "Hibas e-mail cim: " + param);
            }
            else {
                this.email=param;
            }
        } else {
            throw new TelepuleskezeloException(obj, "Hibas e-mail cim: " + param);
        }

    }

    public void ujKerulet(String param, int szam) {
        Kerulet obj = new Kerulet(param, szam);
        keruletek.add(obj);
    }

    @Override
    public String toString() {
        return "Telepules{" +
                "nev='" + nev + '\'' +
                ", terulet=" + terulet +
                ", keruletek=" + keruletek +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }

    public void ujLakok(String param, int szam) throws TelepuleskezeloException {
        int a = 0;
        Telepules obj = new Telepules(nev, terulet);
        Iterator<Kerulet> it = keruletek.iterator();
        while (it.hasNext()) {
            Kerulet elem = it.next();
            if (elem.getNev().equalsIgnoreCase(param)) {

                a = elem.getLakosokSzama() + szam;
                elem.setLakosokSzama(a);
            }
        }
        if (a == 0) {
            throw new TelepuleskezeloException(obj, "Nem talalhato a megadott kerulet: " + param);
        }




    }

    public int getLakosokSzama() {
        int a = 0;
        Iterator<Kerulet> it = keruletek.iterator();
        while (it.hasNext()) {
            Kerulet elem = it.next();
            a += elem.getLakosokSzama();
        }
        return a;
    }

    public double nepsuruseg() {
        return getLakosokSzama() / terulet;
    }


    public class Kerulet {
        private final String nev;
        private int lakosokSzama;

        public String getNev() {
            return nev;
        }

        public int getLakosokSzama() {
            return lakosokSzama;
        }

        public void setLakosokSzama(int lakosokSzama) {
            this.lakosokSzama = lakosokSzama;
        }

        private Kerulet(String nev, int lakosokSzama) {
            this.nev = nev;
            this.lakosokSzama = lakosokSzama;
        }

        public double lakokAranya() {
            double d = this.lakosokSzama;
            return d / Telepules.this.getLakosokSzama();
        }

        @Override
        public String toString() {
            return this.nev + " (" + Telepules.this.nev + ")";
        }

    }
}
