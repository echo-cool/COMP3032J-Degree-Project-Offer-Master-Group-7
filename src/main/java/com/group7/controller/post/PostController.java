package com.group7.controller.post;

import com.group7.db.jpa.Post;
import com.group7.db.jpa.PostCategory;
import com.group7.db.jpa.PostCategoryRepository;
import com.group7.db.jpa.PostRepository;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Resource
    PostRepository postRepository;

    @Resource
    PostCategoryRepository postCategoryRepository;

    @GetMapping("/public/getAllPosts")
    public R getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return R.ok().data("posts", allPosts);
    }

    @GetMapping("/public/getAllCategories")
    public R getAllCategories() {
        List<PostCategory> allPostCategories = postCategoryRepository.findAll();
        return R.ok().data("categories", allPostCategories);
    }

}
