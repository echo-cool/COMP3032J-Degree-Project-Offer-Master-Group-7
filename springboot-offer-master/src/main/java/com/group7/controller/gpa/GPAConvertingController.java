package com.group7.controller.gpa;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.EGPAScale;
import com.group7.entitiy.excel.GPAReportData;
import com.group7.service.GPAConvertingService;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import com.group7.utils.handler.exception.Group7Exception;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

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

    @Resource
    private ProfileRepository profileRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private GradeRepository gradeRepository;

    @Resource JwtUtils jwtUtils;

    @PostMapping("/gpa-convert-excel-upload")
    public R convertGPA(MultipartFile file, HttpServletRequest request, @RequestParam(required = false) EGPAScale originalScale){
        // get user from the response
        User user = jwtUtils.getUserFromRequestByToken(request);

        // check original scale
        if (originalScale != EGPAScale.UCD && originalScale != EGPAScale.CHINA){
            return R.error().message("Invalid original GPA scale!");
        }

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

        // convert the GPA using this file
        try{
            gpaConvertingService.convertGPA(file, originalScale, userRepository, profileRepository, gradeRepository, user);
        }catch (Group7Exception e){
            return R.error().message(e.getMsg());
        }

        // query out the user grade rows
        List<Grade> userGrades = gradeRepository.findAllByUser(user);
        // query out the converted GPA of this user
        double convertedGPA = user.getProfile().getGpa();

        // generate GPA report to the resources dir
        String reportURL = generateGPAReport(request);

        return R.ok().data("gradeRows", userGrades).data("convertedGPA", convertedGPA).data("reportURL", reportURL);
    }

    @RequestMapping("/download-template")
    public R downloadTemplate(HttpServletResponse response) {
        // get the path of the template
        String projectDir = System.getProperty("user.dir");
        String pre = projectDir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar
                + "resources" + File.separatorChar + "static" + File.separatorChar + "excel" + File.separatorChar;
        String path = pre + "GPA_Convert_Template.xlsx";

        // download the template
        downloadFile("GPA_Convert_Template.xlsx", path, response);
        return R.ok();
    }

    /**
     * @param filename e.g. GPA_Convert_Template.xlsx
     * @param path e.g. .../static/excel/GPA_Convert_Template.xlsx
     */
    private void downloadFile(String filename, String path, HttpServletResponse response){
        FileInputStream fis = null;
        ServletOutputStream sos = null;
        try {
            // 设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

            fis = new FileInputStream(path);
            sos = response.getOutputStream();
            IOUtils.copy(fis, sos);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Download failed!");
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
    }

    private String generateGPAReport(HttpServletRequest request){
        // get user from the response
        User user = jwtUtils.getUserFromRequestByToken(request);

        // create the Excel of the converted GPA report
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String filename = "GPA_Convert_Report_" + user.getUsername().replaceAll(" ", "_") + uuid + ".xlsx";
        String projectDir = System.getProperty("user.dir");
        if(Objects.equals(projectDir, "/")){
            projectDir = "";
        }
        String pre = projectDir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar
                + "resources" + File.separatorChar + "static" + File.separatorChar + "excel" + File.separatorChar
                + "reports" + File.separatorChar;
        String savePath = pre + filename;
        File file = new File(savePath);

        // write data into Excel
        EasyExcel.write(file, GPAReportData.class)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet("GPA converting report")
                .doWrite(getGPAReportData(user));

        // return the file url e.g. "static/excel/..."
        return "static/excel/reports/" + filename;
    }

    @RequestMapping("/download-gpa-report")
    public R downloadGPAReport(HttpServletRequest request, HttpServletResponse response) {
        // get user from the response
        User user = jwtUtils.getUserFromRequestByToken(request);

        // create the Excel of the converted GPA report
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String filename = "GPA_Convert_Report_" + user.getUsername().replaceAll(" ", "_") + uuid + ".xlsx";
        String projectDir = System.getProperty("user.dir");
        if(Objects.equals(projectDir, "/")){
            projectDir = "";
        }
        String pre = projectDir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar
                + "resources" + File.separatorChar + "static" + File.separatorChar + "excel" + File.separatorChar
                + "reports" + File.separatorChar;
        String savePath = pre + filename;
        File file = new File(savePath);

        // write data into Excel
        EasyExcel.write(file, GPAReportData.class)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet("GPA converting report")
                .doWrite(getGPAReportData(user));

        // download this Excel
        downloadFile(filename, savePath, response);

        return R.ok();
    }

    /**
     * This is required for writing the GPA report Excel file.
     * @param user We will query the Grade rows of this user.
     * @return A list of Data obj, each will be a row in the Excel.
     */
    private List<GPAReportData> getGPAReportData(User user){
        // create a list to store Data
        ArrayList<GPAReportData> list = new ArrayList<>();

        // query the Grades (rows) of this user
        Set<Grade> grades = user.getGrades();
        int order = 1;
        for (Grade grade : grades){
            // create a Data row
            GPAReportData data = new GPAReportData();
            data.setOrder(order);
            data.setCourseName(grade.getCourseName());
            data.setCredits(grade.getCredits());
            data.setGrade(grade.getGrade());
            data.setGradeUS(grade.getGradeUS());
            data.setGradePointsUS(grade.getGradePointUS());
            // add row to list
            list.add(data);
            order++;
        }

        return list;
    }
}
