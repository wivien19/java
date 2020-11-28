package application.controller;


import application.dao.FilmDAO;
import application.dao.FilmstudioDAO;
import application.model.Film;
import application.model.Filmstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class FilmstudioController {
    @Autowired
    private FilmstudioDAO filmstudioDAO;

    @GetMapping(value = "/filmstudiok")
    public String listFilmstudiok(Model model) {
        model.addAttribute("filmstudiok", filmstudioDAO.listFilmstudiok());


        return "filmstudio";
    }

    @GetMapping(value = "filmstudiok/delete/{fkod}")
    public String deleteFilmstudiok(@PathVariable("fkod") int fkod) {
        filmstudioDAO.deleteFilmstudiok(fkod);

        return "redirect:/filmstudiok";
    }

    @PostMapping(value = "/filmstudiok/add")
    public String addFilmstudio(@RequestParam("hely") String hely, @RequestParam("igazgato") String igazgato, @RequestParam("alkalmazottakSzama") int alkalmazottakSzama, @RequestParam("alapitasIdeje") Date alapitasIdeje) {
        Filmstudio filmstudio = new Filmstudio(hely, igazgato, alkalmazottakSzama, alapitasIdeje);
        filmstudioDAO.insertFilmstudio(filmstudio);

        return "redirect:/filmstudiok";
    }

    @PostMapping(value = "/filmstudiok/update/{fkod}")
    public String updateFilmstudio(@PathVariable("fkod") int fkod, @RequestParam("hely") String hely, @RequestParam("igazgato") String igazgato, @RequestParam("alkalmazottakSzama") int alkalmazottakSzama, @RequestParam("alapitasIdeje") Date alapitasIdeje) {
        filmstudioDAO.updateFilmstudio(fkod, hely, igazgato, alkalmazottakSzama, alapitasIdeje);

        return "redirect:/filmstudiok";
    }

    @GetMapping(value = "/filmstudiok/edit/{fkod}")
    public String editFilmstudio(@PathVariable("fkod") int fkod, Model model) {
        Filmstudio filmstudio = filmstudioDAO.getFilmstudioById(fkod);
        model.addAttribute("filmstudio", filmstudio);

        return "updateFilmstudio";
    }

}
