package com.lisitsin.cotrollers;

import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.repositories.impl.jsonImpl.JsonPostRepositoryImpl;
import com.lisitsin.services.PostService;
import com.lisitsin.services.impl.PostServiceImpl;

import java.util.Date;
import java.util.List;

public class PostController {

    private final PostService postService;
    
    public PostController(){
        postService = new PostServiceImpl();
    }
    
    public Post savePost(String content, List<Label> labels) {
        Post post = new Post(content, new Date(), new Date(), labels);
        postService.save(post);
        return post;
    }

    public List<Post> getPosts() {
        return postService.getAll();
    }

    public Post getPostById(long id) {
        return postService.getById(id);
    }

    public Post update(Post post) {
        return postService.update(post);
    }

    public void delete(long id) {
        postService.deleteById(id);
    }
}
