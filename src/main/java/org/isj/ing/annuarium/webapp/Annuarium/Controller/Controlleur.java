/*
package org.isj.ing.annuarium.webapp.Annuarium.Controller;

import com.ctc.wstx.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icategorie;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Iproduit;
import org.isj.ing.annuarium.webapp.Annuarium.config.FilleUploadUtil;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Categorie;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Produit;
import org.isj.ing.annuarium.webapp.Annuarium.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Slf4j
@Controller

public class Controlleur {
    @Autowired
    private Iproduit iproduit;
    @Autowired
    private Icategorie icategorie;


    @GetMapping("/acceuil")
    public String pageAccueil(Model model) {
        return "index";
    }

    @GetMapping("/Enregistrer")
    public String pageenregistrement(Produit prd){
        */
/*,
        @RequestParam("image")MultipartFile multipartFile)throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        prd.setNomImage(fileName);
        Produit saveProd = prdRepo.save(prd);
        String uploadDir = "ImageProduit/" + saveProd.getId();
        FilleUploadUtil.saveFile(uploadDir,fileName,multipartFile);*//*

        return "saveproduit";
    }

    @GetMapping("/Listes")
    public String pageListeProduit(Model model)  {
        List<Produit> prd =iproduit.listProduit();
        List<Categorie> cat=icategorie.listCat();
        model.addAttribute("cat",cat);
        model.addAttribute("prd",prd);
        return "listeproduit";
    }

}

*/
