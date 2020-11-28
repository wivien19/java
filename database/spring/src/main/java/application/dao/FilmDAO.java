package application.dao;


import application.model.Film;
import application.model.Filmstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Date;
import java.util.*;

@Repository
public class FilmDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertFilm(Film film) {
        String sql = "INSERT INTO film(cim, idotartam, eredetinyelv, fkod) VALUES (?, ?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql,
                film.getCim(), film.getIdotartam(), film.getEredetinyelv(), film.getFkod());
    }

    public List<Film> listFilms() {
        String sql = "SELECT * FROM film";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Film> result = new ArrayList<Film>();
        for (Map<String, Object> row : rows) {
            Film film = new Film();
            film.setFid((Integer) row.get("fid"));
            film.setCim((String) row.get("cim"));
            film.setIdotartam((Integer) row.get("idotartam"));
            film.setEredetinyelv((String) row.get("eredetinyelv"));
            film.setFkod((Integer) row.get("fkod"));
            result.add(film);
        }

        return result;
    }

    public void deleteFilm(int fid) {
        String sql = "DELETE FROM film WHERE fid=" + fid;
        getJdbcTemplate().update(sql);
    }

    public void updateFilm(int fid, String cim, int idotartam, String eredetinyelv, int fkod) {

        String sql = "UPDATE film SET cim='" + cim + "', idotartam='" + idotartam + "',  eredetinyelv='" + eredetinyelv + "', fkod='" + fkod + "' WHERE fid=" + fid;
        getJdbcTemplate().update(sql);

    }

    public Film getFilmById(int id) {
        String sql = "SELECT * FROM film WHERE fid=" + id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Film> result = new ArrayList<Film>();
        for (Map<String, Object> row : rows) {
            Film film = new Film();
            film.setFid((Integer) row.get("fid"));
            film.setCim((String) row.get("cim"));
            film.setIdotartam((Integer) row.get("idotartam"));
            film.setEredetinyelv((String) row.get("eredetinyelv"));
            film.setFkod((Integer) row.get("fkod"));
            result.add(film);
        }

        return result.get(0);
    }

    public SortedMap<Integer, Long> kevesebbMintSzazhuszPerc() {
        String sql = "SELECT film.fid, COUNT(jatszik.szid) AS negy FROM film, jatszik WHERE film.fid = jatszik.fid AND film.idotartam > 120 GROUP BY film.fid, jatszik.fid HAVING COUNT(jatszik.szid) > 0";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        SortedMap<Integer, Long> result = new TreeMap<>();

        for (Map<String, Object> row : rows) {

            result.put((Integer) row.get("fid"), (Long) row.get("negy"));

        }

        return result;

    }

    public SortedMap<Integer, String> szineszekKeresete() {
        String sql = "SELECT jatszik.szid, SUM(szereplesek.fizetes) AS negy FROM jatszik, szereplesek WHERE jatszik.kod = szereplesek.kod GROUP BY jatszik.szid HAVING SUM(szereplesek.fizetes) > 999";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        SortedMap<Integer, String> result = new TreeMap<>();

        for (Map<String, Object> row : rows) {

            result.put((Integer) row.get("szid"), row.get("negy").toString());

        }

        return result;
    }

    public List<String> listFilmIgazgatok() {

        String sql = "SELECT igazgato from filmstudio WHERE EXISTS(select * from filmstudio, szinesz WHERE szinesz.fkod = filmstudio.fkod) AND filmstudio.alapitasIdeje > '2012-01-01' ORDER BY filmstudio.alkalmazottakSzama DESC";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<String> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {

            result.add(row.get("igazgato").toString());
        }

        return result;
    }


}