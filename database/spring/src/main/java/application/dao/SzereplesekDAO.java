package application.dao;

import application.model.Szereplesek;
import application.model.Szinesz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.IdGenerator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SzereplesekDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertSzereplesek(Szereplesek szereplesek) {
        String sql = "INSERT INTO szereplesek(helyszin, szerzodes_vege, fizetes) VALUES (?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql,
              szereplesek.getHelyszin(), szereplesek.getSzerzodes_vege(), szereplesek.getFizetes() );
    }

    public List<Szereplesek> listSzereplesek() {
        String sql = "SELECT * FROM szereplesek";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Szereplesek> result = new ArrayList<Szereplesek>();
        for (Map<String, Object> row : rows) {
            Szereplesek szereplesek = new Szereplesek();
            szereplesek.setKod((Integer) row.get("kod"));
            szereplesek.setHelyszin((String) row.get("helyszin"));
            szereplesek.setSzerzodes_vege((Date) row.get("szerzodes_vege"));
            szereplesek.setFizetes((Integer) row.get("fizetes"));

            result.add(szereplesek);
        }

        return result;
    }
    public void deleteSzereplesek(int kod) {
        String sql = "DELETE FROM szereplesek WHERE kod=" + kod;
        getJdbcTemplate().update(sql);
    }
    public void updateSzereplesek(int kod, String helyszin, Date szerzodes_vege, int fizetes) {

        String sql = "UPDATE szereplesek SET helyszin='"+ helyszin +"', szerzodes_vege='"+ szerzodes_vege +"', fizetes='"+fizetes+"'  WHERE kod=" + kod;
        getJdbcTemplate().update(sql);

    }

    public Szereplesek getSzereplesekById(int id){
        String sql = "SELECT * FROM szereplesek WHERE kod="+id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Szereplesek> result = new ArrayList<Szereplesek>();
        for(Map<String, Object> row:rows){
            Szereplesek szereplesek = new Szereplesek();
            szereplesek.setKod((Integer) row.get("kod"));
            szereplesek.setHelyszin((String)  row.get("helyszin"));
            szereplesek.setSzerzodes_vege((Date) row.get("szerzodes_vege"));
            szereplesek.setFizetes((Integer) row.get("fizetes"));
            result.add(szereplesek);
        }

        return result.get(0);
    }
}
