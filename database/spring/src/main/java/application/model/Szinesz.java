package application.model;

import java.sql.Date;

public class Szinesz {
    int szid;
    String nev;
    Date szuletesiIdo;
    int fkod;

    public int getSzid() {
        return szid;
    }

    public void setSzid(int szid) {
        this.szid = szid;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuletesiIdo() {
        return szuletesiIdo;
    }

    public void setSzuletesiIdo(Date szuletesiIdo) {
        this.szuletesiIdo = szuletesiIdo;
    }

    public int getFkod() {
        return fkod;
    }

    public void setFkod(int fkod) {
        this.fkod = fkod;
    }

    public Szinesz() {
    }

    public Szinesz(int szid, String nev, Date szuletesiIdo, int fkod) {
        this.szid = szid;
        this.nev = nev;
        this.szuletesiIdo = szuletesiIdo;
        this.fkod = fkod;
    }

    public Szinesz(String nev, Date szuletesiIdo, int fkod) {
        this.nev = nev;
        this.szuletesiIdo = szuletesiIdo;
        this.fkod = fkod;
    }
}
