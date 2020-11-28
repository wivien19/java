package application.dao;

import application.model.Film;
import application.model.Filmstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class FilmstudioDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertFilmstudio(Filmstudio filmstudio) {
        String sql = "INSERT INTO filmstudio(hely, igazgato,alkalmazottakSzama, alapitasIdeje) VALUES (?, ?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql,
                filmstudio.getHely(), filmstudio.getIgazgato(), filmstudio.getAlkalmazottakSzama(), filmstudio.getAlapitasideje());
    }

    public List<Filmstudio> listFilmstudiok() {
        String sql = "SELECT * FROM filmstudio";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Filmstudio> result = new ArrayList<Filmstudio>();
        for (Map<String, Object> row : rows) {
            Filmstudio filmstudio = new Filmstudio();
            filmstudio.setFkod((Integer) row.get("fkod"));
            filmstudio.setHely((String) row.get("hely"));
            filmstudio.setIgazgato((String) row.get("igazgato"));
            filmstudio.setAlkalmazottakSzama((Integer) row.get("alkalmazottakSzama"));
            filmstudio.setAlapitasideje((Date) row.get("alapitasIdeje"));
            result.add(filmstudio);
        }

        return result;
    }

    public void deleteFilmstudiok(int fkod) {
        String sql = "DELETE FROM filmstudio WHERE fkod=" + fkod;
        getJdbcTemplate().update(sql);
    }

    public void updateFilmstudio(int fkod, String hely, String igazgato, int alkamazottakSzama, Date alapitasIdeje) {

        String sql = "UPDATE filmstudio SET hely='" + hely + "', igazgato='" + igazgato + "', alkalmazottakSzama='" + alkamazottakSzama + "' , alapitasIdeje='" + alapitasIdeje + "'  WHERE fkod=" + fkod;
        getJdbcTemplate().update(sql);

    }

    public Filmstudio getFilmstudioById(int id) {
        String sql = "SELECT * FROM filmstudio WHERE fkod=" + id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Filmstudio> result = new ArrayList<Filmstudio>();
        for (Map<String, Object> row : rows) {
            Filmstudio filmstudio = new Filmstudio();
            filmstudio.setFkod((Integer) row.get("fkod"));
            filmstudio.setHely((String) row.get("hely"));
            filmstudio.setIgazgato((String) row.get("igazgato"));
            filmstudio.setAlkalmazottakSzama((Integer) row.get("alkalmazottakSzama"));
            filmstudio.setAlapitasideje((Date) row.get("alapitasIdeje"));
            result.add(filmstudio);
        }

        return result.get(0);
    }

}
