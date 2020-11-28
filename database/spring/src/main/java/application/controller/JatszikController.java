package application.controller;

import application.dao.FilmstudioDAO;
import application.dao.JatszikDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JatszikController {
    @Autowired
    private JatszikDAO jatszikDAO;

    @GetMapping(value = "/jatszik2")
    public String listJatszik(Model model) {
        model.addAttribute("jatszik",jatszikDAO.listJatszik());


        return "jatszik2";
    }
}
