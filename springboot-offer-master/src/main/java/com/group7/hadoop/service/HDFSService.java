package com.group7.hadoop.service;

import org.apache.hadoop.fs.BlockLocation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/3-23:05
 * @Project: springboot-offer-master
 * @Package: com.group7.hadoop.service
 * @Description:
 **/
public interface HDFSService {

    // 创建文件夹
    boolean makeFolder(String path);
    // 是否存在文件
    boolean existFile(String path);

    List<Map<String, Object>> readCatalog(String path);

    boolean createFile(String path, MultipartFile file);

    String readFileContent(String path);

    List<Map<String, Object>> listFile(String path);

    boolean renameFile(String oldName, String newName);

    boolean deleteFile(String path);

    boolean uploadFile(String path, String uploadPath);

    boolean downloadFile(String path, String downloadPath);

    boolean copyFile(String sourcePath, String targetPath);

    byte[] openFileToBytes(String path);

    BlockLocation[] getFileBlockLocations(String path);

}