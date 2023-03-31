package com.group7.service.impl;

import com.group7.service.PostService;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public String getImageFileName(MultipartFile file) {
        // e.g. test.png
        String filename = file.getOriginalFilename();

        // to avoid duplicate name
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid + filename;

        // concatenate the path for this avatar
//        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
//        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
//                + "\\src\\main\\resources\\static\\upload\\post\\";

        String projectDir = System.getProperty("user.dir");
        if(Objects.equals(projectDir, "/")){
            projectDir = "";
        }
        String pre = projectDir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar
                + "resources" + File.separatorChar + "static" + File.separatorChar + "upload" + File.separatorChar
                + "post" + File.separatorChar;

        String savePath = pre + filename;

        // store the file
        try {
            file.transferTo(new File(savePath));
            // generate the http url for this pic
            // return the pic url to store in db
            return "upload/post/" + filename;
        } catch (IOException e) {
            return null;
        }
    }
}
