package application.controller;

import application.dao.SzereplesekDAO;
import application.dao.SzineszDAO;
import application.model.Szereplesek;
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
public class SzereplesekController {
    @Autowired
    private SzereplesekDAO szereplesekDAO;

    @GetMapping(value = "/szereplesek")
    public String listSzereplesek(Model model) {
        model.addAttribute("szereplesek", szereplesekDAO.listSzereplesek());


        return "szereplesek";
    }

    @GetMapping(value = "szereplesek/delete/{kod}")
    public String deleteSzinesz(@PathVariable("kod") int kod) {
        szereplesekDAO.deleteSzereplesek(kod);

        return "redirect:/szereplesek";
    }

    @PostMapping(value = "/szereplesek/add")
    public String addSzereples(@RequestParam("helyszin") String helyszin, @RequestParam("szerzodes_vege") Date szerzodes_vege, @RequestParam("fizetes") int fizetes) {
        Szereplesek szereplesek = new Szereplesek(helyszin, szerzodes_vege, fizetes);
        szereplesekDAO.insertSzereplesek(szereplesek);

        return "redirect:/szereplesek";
    }

    @PostMapping(value = "/szereplesek/update/{kod}")
    public String updateSzereplesek(@PathVariable("kod") int kod, @RequestParam("helyszin") String helyszin, @RequestParam("szerzodes_vege") Date szerzodes_vege, @RequestParam("fizetes") int fizetes) {
        szereplesekDAO.updateSzereplesek(kod, helyszin, szerzodes_vege, fizetes);
        return "redirect:/szereplesek";
    }

    @GetMapping(value = "/szereplesek/edit/{kod}")
    public String editSzereplesek(@PathVariable("kod") int kod, Model model) {
        Szereplesek szereplesek = szereplesekDAO.getSzereplesekById(kod);
        model.addAttribute("szereplesek", szereplesek);

        return "updateSzereplesek";
    }
}
