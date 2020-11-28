package application.model;

import java.sql.Date;

public class Szereplesek {
    int kod;
    String helyszin;
    Date szerzodes_vege;
    int fizetes;

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public Date getSzerzodes_vege() {
        return szerzodes_vege;
    }

    public void setSzerzodes_vege(Date szerzodes_vege) {
        this.szerzodes_vege = szerzodes_vege;
    }

    public int getFizetes() {
        return fizetes;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }

    public Szereplesek() {
    }

    public Szereplesek(int kod, String helyszin, Date szerzodes_vege, int fizetes) {

        this.kod = kod;
        this.helyszin = helyszin;
        this.szerzodes_vege = szerzodes_vege;
        this.fizetes = fizetes;
    }

    public Szereplesek(String helyszin, Date szerzodes_vege, int fizetes) {
        this.helyszin = helyszin;
        this.szerzodes_vege = szerzodes_vege;
        this.fizetes = fizetes;
    }
}
