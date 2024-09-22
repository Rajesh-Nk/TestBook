package com.rajesh.testBook.api.TestBook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    //static way to store image in the specified path only
    //public final String UPLOAD_DIR = "C:\\Users\\Rajesh\\Downloads\\TestBook\\TestBook\\src\\main\\resources\\static\\image";

    //Dynamically store the image in any system
    public final String UPLOAD_DIR = new ClassPathResource("/static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;
        try {
/*
            InputStream is = multipartFile.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

// Traditional method using io package
           //write
           FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
           fos.write(data);

           fos.flush();
           fos.close();
           is.close();
           f=true;
*/


            // Another way to perform the same task using nio package
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipartFile.
                    getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;




        } catch (Exception e) {
            e.printStackTrace();
        }


        return f;
    }
}
