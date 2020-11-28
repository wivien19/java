package application.model;
import java.io.Serializable;

public class Film implements Serializable{
    int fid;
    String cim;
    int idotartam;
    String eredetinyelv;
    int fkod;

    public Film(int fid, String cim, int idotartam, String eredetinyelv, int fkod) {
        this.fid = fid;
        this.cim = cim;
        this.idotartam = idotartam;
        this.eredetinyelv = eredetinyelv;
        this.fkod = fkod;
    }

    public Film(String cim, int idotartam, String eredetinyelv, int fkod) {
        this.cim = cim;
        this.idotartam = idotartam;
        this.eredetinyelv = eredetinyelv;
        this.fkod = fkod;
    }

    public Film() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public String getEredetinyelv() {
        return eredetinyelv;
    }

    public void setEredetinyelv(String eredetinyelv) {
        this.eredetinyelv = eredetinyelv;
    }

    public int getFkod() {
        return fkod;
    }

    public void setFkod(int fkod) {
        this.fkod = fkod;
    }
}
