package com.group7.hadoop.controller;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/3-23:40
 * @Project: springboot-offer-master
 * @Package: com.group7.hadoop.controller
 * @Description:
 **/
import com.group7.hadoop.service.HDFSService;
import com.group7.utils.common.R;
import org.apache.hadoop.fs.BlockLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/hdfs")
public class HDFSController {

    @Autowired
    private HDFSService hdfsService;

    @GetMapping("/hello")
    public R test() {
        return R.ok();
    }


    @PostMapping("/folder")
    public R createFolder(
            @RequestParam(name = "path", required = true)
            String path
    ){
        return R.ok().data("result", hdfsService.makeFolder(path));
    }


    @PostMapping("/exist")
    public R existFile(
            @RequestParam(name = "path", required = true)
            String path
    ) {
        return R.ok().data("result", hdfsService.existFile(path));
    }

    @GetMapping("/catalog")
    public R readCatalog(
            @RequestParam(name = "path", required = true)
            String path
    ) {
        return R.ok().data("result", hdfsService.readCatalog(path));
    }

    @PostMapping(value = "/file", consumes = "multipart/form-data")
    public R createFile(
            @RequestParam(name = "path", required = true)
            String path,
            @RequestParam(name = "file", required = true)
            MultipartFile file
    ) {
        return R.ok().data("result", hdfsService.createFile(path, file));
    }

    @PostMapping("/file/content")
    public R readFileContent(
            @RequestParam(name = "path", required = true)
            String path
    ) {
        return R.ok().data("result", hdfsService.readFileContent(path));
    }

//
//    @GetMapping("/file/list")
//    public APIResponse<List<Map<String, Object>>> listFile(
//            @ApiParam(name = "path", required = true)
//            @RequestParam(name = "path", required = true)
//            String path
//    ) {
//        return APIResponse.success(hdfsService.listFile(path));
//    }
//
//    @ApiOperation("rename file")
//    @PutMapping("/file")
//    public APIResponse<Boolean> renameFile(
//            @ApiParam(name = "oldName", required = true)
//            @RequestParam(name = "oldName", required = true)
//            String oldName,
//            @ApiParam(name = "newName", required = true)
//            @RequestParam(name = "newName", required = true)
//            String newName
//    ) {
//        return APIResponse.success(hdfsService.renameFile(oldName, newName));
//    }
//
//    @ApiOperation("delete file")
//    @DeleteMapping("/file")
//    public APIResponse<Boolean> deleteFile(
//            @ApiParam(name = "path", required = true)
//            @RequestParam(name = "path", required = true)
//            String path
//    ) {
//        return APIResponse.success(hdfsService.deleteFile(path));
//    }
//
//    @ApiOperation("upload file")
//    @PostMapping("/file/upload")
//    public APIResponse<Boolean> uploadFile(
//            @ApiParam(name = "path", required = true)
//            @RequestParam(name = "path", required = true)
//            String path,
//            @ApiParam(name = "uploadPath", required = true)
//            @RequestParam(name = "uploadPath", required = true)
//            String uploadPath
//    ) {
//        return APIResponse.success(hdfsService.uploadFile(path, uploadPath));
//    }
//
//    @ApiOperation("download file")
//    @PostMapping("/file/download")
//    public APIResponse<Boolean> downloadFile(
//            @ApiParam(name = "path", required = true)
//            @RequestParam(name = "path", required = true)
//            String path,
//            @ApiParam(name = "downloadPath", required = true)
//            @RequestParam(name = "downloadPath", required = true)
//            String downloadPath
//    ) {
//        return APIResponse.success(hdfsService.downloadFile(path, downloadPath));
//    }
//
//    @ApiOperation("copy file")
//    @PostMapping("/file/copy")
//    public APIResponse<Boolean> copyFile(
//            @ApiParam(name = "sourcePath", required = true)
//            @RequestParam(name = "sourcePath", required = true)
//            String sourcePath,
//            @ApiParam(name = "targetPath", required = true)
//            @RequestParam(name = "targetPath", required = true)
//            String targetPath
//    ) {
//        return APIResponse.success(hdfsService.copyFile(sourcePath, targetPath));
//    }
//
//    @ApiOperation("open file to types")
//    @PostMapping("file/to-bytes")
//    public APIResponse<Byte[]> openFileToBytes(
//            @ApiParam(name = "path", required = true)
//            @RequestParam(name = "path", required = true)
//            String path
//    ) {
//        return APIResponse.success(hdfsService.openFileToBytes(path));
//    }
//
//    @ApiOperation("get file block locations")
//    @GetMapping("/file/block-localtions")
//    public APIResponse<BlockLocation[]> getFileBlockLocations(
//            @ApiParam(name = "path", required = true)
//            @RequestParam(name = "path", required = true)
//            String path
//    ){
//        return APIResponse.success(hdfsService.getFileBlockLocations(path));
//    }
}