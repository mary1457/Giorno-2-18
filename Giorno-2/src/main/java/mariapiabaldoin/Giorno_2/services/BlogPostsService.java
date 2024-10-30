package mariapiabaldoin.Giorno_2.services;

import mariapiabaldoin.Giorno_2.entities.BlogPost;
import mariapiabaldoin.Giorno_2.exceptions.NotFoundException;
import mariapiabaldoin.Giorno_2.payloads.NewBlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPostsList = new ArrayList<>();

    public List<BlogPost> findAll() {
        return this.blogPostsList;
    }


    public BlogPost findById(int blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsList) {
            if (blogPost.getId() == blogPostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    public BlogPost saveBlogPost(NewBlogPostPayload body) {
        Random rndm = new Random();
        BlogPost newBlogPost = new BlogPost(body.getCategoria(), body.getTitolo(), body.getContenuto(), body.getTempoLettura());

        newBlogPost.setId(rndm.nextInt(1, 10000));
        String coverUrl = "https://picsum.photos/200/300";
        newBlogPost.setCover(coverUrl);
        this.blogPostsList.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost findByIdAndUpdate(int blogPostId, NewBlogPostPayload body) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsList) {
            if (blogPost.getId() == blogPostId) {
                found = blogPost;
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setContenuto(body.getContenuto());
                found.setTempoLettura(body.getTempoLettura());
            }
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    public void findByIdAndDelete(int blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsList) {
            if (blogPost.getId() == blogPostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogPostId);
        this.blogPostsList.remove(found);
    }

}
