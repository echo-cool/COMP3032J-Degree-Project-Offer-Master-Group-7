package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.File;

@Data
@Accessors(chain = true)
public class PostCreateVo {
    private String title;

    private String content;

    private File image;
}
