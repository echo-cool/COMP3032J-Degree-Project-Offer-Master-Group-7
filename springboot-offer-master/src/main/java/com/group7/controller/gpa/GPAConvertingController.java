package com.group7.controller.gpa;

import com.group7.service.GPAConvertingService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 14:02
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/gpa-convert")
public class GPAConvertingController {

    @Resource
    private GPAConvertingService gpaConvertingService;

    @PostMapping("gpa-convert-excel-upload")
    public R convertGPA(MultipartFile file){
        // check file
        if(file == null){
            return R.error().message("The file cannot be empty!");
        }

        // check the file type (only xls and xlsx)
        String filename = file.getOriginalFilename();
        if (filename != null) {
            // get the file extension
            String extension = filename.substring(filename.lastIndexOf(".") + 1);
            if (!(extension.equals("xls") || extension.equals("xlsx"))) {
                return R.error().message("The file should be .xls or .xlsx only!");
            }
        }

        gpaConvertingService.convertGPA(file, gpaConvertingService);

        return R.ok();
    }

    @RequestMapping("/download-template")
    public R downloadTemplate(HttpServletResponse response) {
        FileInputStream fis = null;
        ServletOutputStream sos = null;
        try {
            String fileName = "GPA_Convert_Template.xlsx";
            // resources下路径，比如文件位置在：resources/file/test.docx
            String path = "static/excel/" + fileName;
            // 设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            ClassPathResource classPathResource = new ClassPathResource(path);
            fis = new FileInputStream(classPathResource.getFile());
            sos = response.getOutputStream();
            IOUtils.copy(fis, sos);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Download failed！");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (sos != null) {
                    sos.flush();
                    sos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return R.ok();
    }
}
