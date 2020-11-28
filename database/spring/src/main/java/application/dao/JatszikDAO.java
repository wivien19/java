package application.dao;

import application.model.Film;
import application.model.Jatszik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JatszikDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
    public List<Jatszik> listJatszik() {
        String sql = "SELECT * FROM jatszik";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Jatszik> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Jatszik jatszik = new Jatszik();
            jatszik.setFid((Integer) row.get("fid"));
            jatszik.setKod((Integer) row.get("kod"));
            jatszik.setSzid((Integer) row.get("szid"));

            result.add(jatszik);
        }

        return result;
    }

}
