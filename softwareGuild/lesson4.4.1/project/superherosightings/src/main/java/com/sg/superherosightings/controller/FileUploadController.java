package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.storage.StorageFileNotFoundException;
import com.sg.superherosightings.storage.StorageService;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    @Autowired
    SuperpowerDao superpowerDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    HeroDao heroDao;

    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    StorageService storageService;
    
    @GetMapping("photos")
    public String uploadPicture(Integer heroId, Model model) {
        Hero hero = heroDao.getHeroById(heroId);
        model.addAttribute("hero", hero);
        return "photos";
    }

    
    // Images uploading and reading
    
    // This endpoint gets current list of uploaded files from the StorageService and loads it into Thymeleaf template
    // It identifies a link to the actual resource by using MvcUriComponentsBuilder
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "photos";
    }

    
    // Loads the resource (if it exists).
    // Sends the resource to the browser to download by using a Content-Disposition response header.
    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    // Handles a multi-part message 'file' and gives it to the StorageService for saving.
    @PostMapping("/")
    public String handleFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        String heroId = request.getParameter("heroId");
        System.out.println("HeroId: " + heroId);
        
        Hero hero = heroDao.getHeroById(Integer.parseInt(heroId));
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        
        hero.setPhotoName(fileName);
        
        heroDao.updatePhotoName(hero);
        
        storageService.store(file);
        // redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/heroes";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
