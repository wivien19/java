package application.model;

public class Jatszik {
    int fid;
    int kod;
    int szid;

    public Jatszik(int fid, int kod, int szid) {
        this.fid = fid;
        this.kod = kod;
        this.szid = szid;
    }

    public Jatszik() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public int getSzid() {
        return szid;
    }

    public void setSzid(int szid) {
        this.szid = szid;
    }
}
