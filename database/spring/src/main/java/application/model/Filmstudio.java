package application.model;

import java.sql.Date;

public class Filmstudio {
    int fkod;
    String hely;
    String igazgato;
    int alkalmazottakSzama;
    java.sql.Date alapitasideje;


    public int getFkod() {
        return fkod;
    }

    public void setFkod(int fkod) {
        this.fkod = fkod;
    }

    public String getHely() {
        return hely;
    }

    public void setHely(String hely) {
        this.hely = hely;
    }

    public String getIgazgato() {
        return igazgato;
    }

    public void setIgazgato(String igazgato) {
        this.igazgato = igazgato;
    }

    public int getAlkalmazottakSzama() {
        return alkalmazottakSzama;
    }

    public void setAlkalmazottakSzama(int alkalmazottakSzama) {
        this.alkalmazottakSzama = alkalmazottakSzama;
    }


    public Filmstudio() {
    }

    public Date getAlapitasideje() {
        return alapitasideje;
    }

    public void setAlapitasideje(Date alapitasideje) {
        this.alapitasideje = alapitasideje;
    }

    public Filmstudio(int fkod, String hely, String igazgato, int alkalmazottakSzama, Date alapitasideje) {
        this.fkod = fkod;
        this.hely = hely;
        this.igazgato = igazgato;
        this.alkalmazottakSzama = alkalmazottakSzama;
        this.alapitasideje = alapitasideje;
    }

    public Filmstudio(String hely, String igazgato, int alkalmazottakSzama, Date alapitasideje) {
        this.hely = hely;
        this.igazgato = igazgato;
        this.alkalmazottakSzama = alkalmazottakSzama;
        this.alapitasideje = alapitasideje;
    }
}
