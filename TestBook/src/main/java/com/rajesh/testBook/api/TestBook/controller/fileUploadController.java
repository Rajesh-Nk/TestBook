package com.rajesh.testBook.api.TestBook.controller;

import com.rajesh.testBook.api.TestBook.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class fileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());
//        System.out.println(file.getOriginalFilename());


        //Validation
        try {


            if (file.getOriginalFilename().isEmpty()) {
                return ResponseEntity.internalServerError().body("Must contain a file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.internalServerError().body("file must be in JPEG format");
            }

            //File upload code

            boolean f = fileUploadHelper.uploadFile(file);

            if (f) {
               // return ResponseEntity.ok("file uploaded successfully");

                // It will return the URI of uploaded file
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().body("Something went wrong. PLease try again!");
    }
}
