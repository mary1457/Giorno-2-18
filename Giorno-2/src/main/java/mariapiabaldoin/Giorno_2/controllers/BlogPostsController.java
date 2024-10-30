package mariapiabaldoin.Giorno_2.controllers;


import mariapiabaldoin.Giorno_2.entities.BlogPost;
import mariapiabaldoin.Giorno_2.payloads.NewBlogPostPayload;
import mariapiabaldoin.Giorno_2.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;


    @GetMapping
    public List<BlogPost> getBlogPost() {
        return this.blogPostsService.findAll();
    }


    @GetMapping("/{blogPostId}")
    public BlogPost findBlogPostById(@PathVariable int blogPostId) {
        return this.blogPostsService.findById(blogPostId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPost(@RequestBody NewBlogPostPayload body) {
        return this.blogPostsService.saveBlogPost(body);
    }


    @PutMapping("/{blogPostId}")
    public BlogPost findBlogPostByIdAndUpdate(@PathVariable int blogPostId, @RequestBody NewBlogPostPayload body) {
        return this.blogPostsService.findByIdAndUpdate(blogPostId, body);
    }


    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findBlogPostByIdAndDelete(@PathVariable int blogPostId) {
        this.blogPostsService.findByIdAndDelete(blogPostId);
    }


}
