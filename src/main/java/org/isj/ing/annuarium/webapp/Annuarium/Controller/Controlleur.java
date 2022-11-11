package org.isj.ing.annuarium.webapp.Annuarium.Controller;

import com.ctc.wstx.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.isj.ing.annuarium.webapp.Annuarium.config.FilleUploadUtil;
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

@Slf4j
@Controller

public class Controlleur {
    @Autowired
    private ProduitRepository prdRepo;

    @GetMapping("/acceuil")
    public String pageAccueil(Model model) {
        return "index";
    }

    @GetMapping("/Enregistrer")
    public String pageenregistrement(Produit prd){
      /*                               @RequestParam("image")MultipartFile multipartFile)throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        prd.setNomImage(fileName);
        Produit saveProd = prdRepo.save(prd);
        String uploadDir = "ImageProduit/" + saveProd.getId();
        FilleUploadUtil.saveFile(uploadDir,fileName,multipartFile);*/
        return "saveproduit";
    }
}
