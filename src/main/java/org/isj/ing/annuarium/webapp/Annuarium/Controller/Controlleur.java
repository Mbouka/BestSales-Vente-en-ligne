package org.isj.ing.annuarium.webapp.Annuarium.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controlleur {
    @GetMapping("/acceuil")
    public String pageAccueil(Model model) { return "/index";}

    @GetMapping("/Enregistrer")
    public String pageenregistrement(Model model) { return "/saveproduit";}
}
