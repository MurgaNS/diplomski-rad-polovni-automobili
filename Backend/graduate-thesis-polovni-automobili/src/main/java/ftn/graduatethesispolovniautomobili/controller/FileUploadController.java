package ftn.graduatethesispolovniautomobili.controller;


import ftn.graduatethesispolovniautomobili.service.FileUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "api/upload-photos")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }


    @PostMapping
    public ResponseEntity<List<String>> uploadPhotos(@RequestParam("photos") MultipartFile[] photos) {

        try {
            String uploadDir = "src/main/resources/images";
            List<String> filesNames = fileUploadService.saveFile(uploadDir, photos);
            return  new ResponseEntity<>(filesNames, HttpStatus.OK);

        }catch (Exception ex) {

            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
