package com.group7.controller.post;

import com.group7.db.jpa.*;
import com.group7.entitiy.UserQueryVo;
import com.group7.service.PostService;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Resource
    PostRepository postRepository;

    @Resource
    PostCategoryRepository postCategoryRepository;

    @Resource
    PostCommentRepository postCommentRepository;

    @Resource
    JwtUtils jwtUtils;

    @Resource
    private PostService postService;

    private static final String[] PIC_TYPES = new String[]{"bmp", "jpg", "jpeg", "png", "gif", "svg"};

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

    @PostMapping("/createPost")
    public R createPost(MultipartHttpServletRequest request) {
        User user = jwtUtils.getUserFromRequestByToken(request);

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String category = request.getParameter("category");
        MultipartFile file = request.getFile("image");

        if (title == null || content == null || file == null || category == null) {
            return R.error().message("The data can not be empty!");
        }

        // check empty file
        if (file.isEmpty()){
            return R.error().message("Upload failed - empty picture");
        }

        // check file type
        String ext = file.getOriginalFilename().split("\\.")[1];
        boolean isValidType = false;
        for (String type : PIC_TYPES){
            if (type.equals(ext)){
                isValidType = true;
                break;
            }
        }
        if(!isValidType){
            return R.error().message("Upload failed - the picture type should be the following: " +
                            "\"bmp\", \"jpg\", \"jpeg\", \"png\", \"gif\", \"svg\"");
        }
        if (user == null){
            return R.error().message("Upload failed - You should login first.");
        }


        // store the file locally
        String newFileName = postService.getImageFileName(file);
        if (newFileName == null){
            return R.error().message("Upload failed - Try it again latter.");
        }

        PostCategory postCategory = postCategoryRepository.findByName(category).orElse(null);

        Post post = new Post(title, content, postCategory, newFileName, user);
        postRepository.save(post);

        return R.ok();
    }

    @PostMapping("/createPostComment")
    public R createPost(HttpServletRequest request) {
        User user = jwtUtils.getUserFromRequestByToken(request);

        String content = request.getParameter("comment");
        Post post = postRepository.findById(Long.valueOf(request.getParameter("postID"))).orElse(null);

        PostComment comment = new PostComment(content, user, post);

        postCommentRepository.save(comment);

        return R.ok();

    }

    @GetMapping("/public/getPost/{postID}")
    public R getPost(@PathVariable("postID") long postID) {
        return R.ok().data("post", postRepository.findById(postID).orElse(null));
    }

    @GetMapping("/public/getPostsByCategory/{category}")
    public R getPost(@PathVariable("category") String category) {
        System.out.println(category);
        return R.ok().data("posts", postRepository.findByCategory_NameIgnoreCase(category));
    }


}
