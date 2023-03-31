package com.group7.controller.article;

import com.group7.db.jpa.ArticleRepository;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Resource
    ArticleRepository articleRepository;

    @Resource
    UserRepository userRepository;

    @GetMapping("/public/getById/{id}")
    public R getPostById(@PathVariable("id") long id) {
        return R.ok().data("article", articleRepository.findById(id).orElse(null));
    }
    @GetMapping("/public/getByUserId/{id}")
    public R getPostByUserId(@PathVariable("id") long id) {
        User user = userRepository.findById(id).orElse(null);
        return R.ok().data("post", articleRepository.findByUser(user).orElse(null));
    }
}
