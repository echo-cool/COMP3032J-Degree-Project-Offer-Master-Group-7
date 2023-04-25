package com.group7.controller.gpa;

import com.group7.service.GPAConvertingService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

        gpaConvertingService.convertGPA(file, gpaConvertingService);

        return R.ok();
    }
}
