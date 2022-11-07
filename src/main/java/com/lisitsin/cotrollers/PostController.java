package com.lisitsin.cotrollers;

import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.services.PostService;

import java.util.Date;
import java.util.List;

public class PostController {

    private final PostService postService;
    
    public PostController(PostService postService){
        this.postService = postService;
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
