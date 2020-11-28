package application.controller;

import application.dao.FilmstudioDAO;
import application.dao.SzineszDAO;
import application.model.Filmstudio;
import application.model.Szinesz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class SzineszController {
    @Autowired
    private SzineszDAO szineszDAO;

    @GetMapping(value = "/szinesz")
    public String listSzineszek(Model model) {
        model.addAttribute("szineszek", szineszDAO.listSzinesz());


        return "szinesz";
    }

    @GetMapping(value = "szinesz/delete/{szid}")
    public String deleteSzinesz(@PathVariable("szid") int szid) {
        szineszDAO.deleteSzinesz(szid);

        return "redirect:/szinesz";
    }

    @PostMapping(value = "/szinesz/add")
    public String addSzinesz(@RequestParam("nev") String nev, @RequestParam("szuletesiIdo") Date szuletesiIdo, @RequestParam("fkod") int fkod) {
        Szinesz szinesz = new Szinesz(nev, szuletesiIdo, fkod);
        szineszDAO.insertSzinesz(szinesz);

        return "redirect:/szinesz";
    }

    @PostMapping(value = "/szinesz/update/{szid}")
    public String updateSzinesz(@PathVariable("szid") int szid, @RequestParam("nev") String nev, @RequestParam("szuletesiIdo") Date szuletesiIdo, @RequestParam("fkod") int fkod) {
        szineszDAO.updateSzinesz(szid, nev, szuletesiIdo, fkod);

        return "redirect:/szinesz";
    }

    @GetMapping(value = "/szinesz/edit/{szid}")
    public String editSzinesz(@PathVariable("szid") int szid, Model model) {
        Szinesz szinesz = szineszDAO.getSzineszById(szid);
        model.addAttribute("szineszek", szinesz);

        return "updateSzinesz";
    }

}

