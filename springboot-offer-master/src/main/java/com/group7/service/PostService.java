package com.group7.service;

import org.springframework.web.multipart.MultipartFile;

public interface PostService {
    public String getImageFileName(MultipartFile file);
}
