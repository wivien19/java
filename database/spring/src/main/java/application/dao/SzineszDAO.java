package application.dao;

import application.model.Filmstudio;
import application.model.Szinesz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SzineszDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertSzinesz(Szinesz szinesz) {
        String sql = "INSERT INTO szinesz(nev, szuletesiIdo, fkod) VALUES (?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql,
                szinesz.getNev(), szinesz.getSzuletesiIdo(), szinesz.getFkod());
    }

    public List<Szinesz> listSzinesz() {
        String sql = "SELECT * FROM szinesz";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Szinesz> result = new ArrayList<Szinesz>();
        for (Map<String, Object> row : rows) {
            Szinesz szinesz = new Szinesz();
            szinesz.setSzid((Integer) row.get("szid"));
            szinesz.setNev((String) row.get("nev"));
            szinesz.setSzuletesiIdo((Date) row.get("szuletesiIdo"));
            szinesz.setFkod((Integer) row.get("fkod"));

            result.add(szinesz);
        }

        return result;
    }

    public void deleteSzinesz(int szid) {
        String sql = "DELETE FROM szinesz WHERE szid=" + szid;
        getJdbcTemplate().update(sql);
    }

    public void updateSzinesz(int szid, String nev, Date szuletesiIdo, int fkod) {

        String sql = "UPDATE szinesz SET nev='" + nev + "', szuletesiIdo='" + szuletesiIdo + "', fkod='" + fkod + "'  WHERE szid=" + szid;
        getJdbcTemplate().update(sql);

    }

    public Szinesz getSzineszById(int id) {
        String sql = "SELECT * FROM szinesz WHERE szid=" + id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Szinesz> result = new ArrayList<Szinesz>();
        for (Map<String, Object> row : rows) {
            Szinesz szinesz = new Szinesz();
            szinesz.setSzid((Integer) row.get("szid"));
            szinesz.setNev((String) row.get("nev"));
            szinesz.setSzuletesiIdo((Date) row.get("szuletesiIdo"));
            szinesz.setFkod((Integer) row.get("fkod"));
            result.add(szinesz);
        }

        return result.get(0);
    }


}
