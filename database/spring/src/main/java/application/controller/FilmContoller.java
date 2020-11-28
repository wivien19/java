package application.controller;

import application.dao.FilmDAO;
import application.dao.SzineszDAO;
import application.model.Film;
import application.model.Szinesz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmContoller {
    @Autowired
    private FilmDAO filmDAO;
    @Autowired
    private SzineszDAO szineszDAO;

    @GetMapping(value = "/film")
    public String listFilm(Model model) {
        model.addAttribute("films", filmDAO.listFilms());


        return "film";
    }

    @PostMapping(value = "/film/add")
    public String addDoge(@RequestParam("cim") String cim, @RequestParam("idotartam") int idotartam, @RequestParam("eredetinyelv") String eredetinyelv, @RequestParam("fkod") int fkod) {

        Film film = new Film(cim, idotartam, eredetinyelv, fkod);
        filmDAO.insertFilm(film);

        return "redirect:/film";
    }

    @GetMapping(value = "/film/delete/{fid}")
    public String deleteDog(@PathVariable("fid") int fid) {
        filmDAO.deleteFilm(fid);

        return "redirect:/film";
    }

    @PostMapping(value = "/film/update/{fid}")
    public String updateDog(@PathVariable("fid") int fid, @RequestParam("cim") String cim, @RequestParam("idotartam") int idotartam, @RequestParam("eredetinyelv") String eredetinyelv, @RequestParam("fkod") int fkod) {

        filmDAO.updateFilm(fid, cim, idotartam, eredetinyelv, fkod);

        return "redirect:/film";
    }

    @GetMapping(value = "/film/edit/{fid}")
    public String editDog(@PathVariable("fid") int fid, Model model) {
        Film film = filmDAO.getFilmById(fid);
        model.addAttribute("film", film);

        return "update-dog";
    }

    @GetMapping(value = "/jatszik")
    public String kevesebbMintSzazhuszPerc(Model model) {

        List<Film> filmek = new ArrayList<Film>();
        List<Long> szineszekSzama = new ArrayList<Long>();

        for (Long integer : filmDAO.kevesebbMintSzazhuszPerc().values()) {
            szineszekSzama.add(integer);
            System.out.println(integer);
        }
        for (Integer integer : filmDAO.kevesebbMintSzazhuszPerc().keySet()) {
            filmek.add(filmDAO.getFilmById(integer));
        }


        model.addAttribute("films", filmek);
        model.addAttribute("szinesz", szineszekSzama);


        return "jatszik";
    }

    @GetMapping(value = "/kereset")
    public String szineszekKeresete(Model model) {

        List<Szinesz> szineszek = new ArrayList<>();
        List<String> kereset = new ArrayList<>();


        for (String integer : filmDAO.szineszekKeresete().values()) {
            kereset.add(integer);
        }
        for (Integer integer : filmDAO.szineszekKeresete().keySet()) {
            szineszek.add(szineszDAO.getSzineszById(integer));
        }


        model.addAttribute("szineszek", szineszek);
        model.addAttribute("kereset", kereset);


        return "kereset";
    }

    @GetMapping(value = "/igazgato")
    public String listFilmIgazgatok(Model model) {


        List<String> igazgatok = new ArrayList<>();


        for (String igazgato : filmDAO.listFilmIgazgatok()) {
            igazgatok.add(igazgato);
        }

        model.addAttribute("igazgatok", igazgatok);


        return "igazgato";
    }


}
