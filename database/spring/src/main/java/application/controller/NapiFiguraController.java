package application.controller;

import application.dao.NapiFiguraDAO;
import application.dao.SzereplesekDAO;
import application.model.NapiFigura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Controller
public class NapiFiguraController {

    @Autowired
    private NapiFiguraDAO NapifiguraDAO;

    @GetMapping(value = "/")
    public String listNapifigurak() {

        return "index";
    }

    @PostMapping(value = "/")
    public String addImg(@RequestParam(value = "img") MultipartFile file) {
        try {
            saveFigura(file);
            System.out.println("sikeres f");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("post vege");
        return "redirect:/";
    }

    public void saveFigura(MultipartFile imageFile) throws Exception {
        String folder = "src/main/resources/static/";
        NapiFigura figura = new NapiFigura();
        String nev = "kepek/figura.jpg";

        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + nev);
        figura.setEleresiut(nev);
        NapifiguraDAO.updateFigura(nev);

        Files.write(path, bytes);
    }
}
