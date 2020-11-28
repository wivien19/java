package application.model;

public class NapiFigura {
    String eleresiut;
    int napiid;

    public NapiFigura(String eleresiut, int napiid) {
        this.eleresiut = eleresiut;
        this.napiid = napiid;
    }

    public NapiFigura() {
    }

    public String getEleresiut() {
        return eleresiut;
    }

    public void setEleresiut(String eleresiut) {
        this.eleresiut = eleresiut;
    }

    public int getNapiid() {
        return napiid;
    }

    public void setNapiid(int napiid) {
        this.napiid = napiid;
    }
}
