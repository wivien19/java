package application.dao;

import application.model.Filmstudio;
import application.model.NapiFigura;
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
public class NapiFiguraDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertNapiFigura(NapiFigura napiFigura) {
        String sql = "INSERT INTO napi_figura(eleresiut) VALUES (?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql,
               napiFigura.getEleresiut() );
    }
    public void updateFigura(String hely) {

        String sql = "UPDATE napi_figura SET eleresiut='"+ hely+ "'  WHERE eleresiut='kepek/figura.jpg'";
        getJdbcTemplate().update(sql);

    }
    public NapiFigura listNapifigurak() {
    String sql = "SELECT * FROM napi_figura  ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<NapiFigura> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            NapiFigura napiFigura = new NapiFigura();


           napiFigura.setEleresiut((String) row.get("eleresiut"));

            result.add(napiFigura);


        }
        System.out.println(result.get(0).getEleresiut());
        return result.get(0);
    }
}
