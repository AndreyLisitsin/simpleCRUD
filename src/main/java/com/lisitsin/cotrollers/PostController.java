package com.lisitsin.cotrollers;

import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.repositories.impl.JsonPostRepositoryImpl;

import java.util.Date;
import java.util.List;

public class PostController {

    private final PostRepository postRepository;
    
    public PostController(){
        postRepository = new JsonPostRepositoryImpl();
    }
    
    public Post savePost(String content, List<Label> labels) {
        Post post = new Post(content, new Date(), new Date(), labels);
        postRepository.save(post);
        return post;
    }

    public List<Post> getPosts() {
        return postRepository.getAll();
    }

    public Post getPostById(long id) {
        return postRepository.getById(id);
    }

    public Post update(Post post) {
        return postRepository.update(post);
    }

    public void delete(long id) {
        postRepository.deleteById(id);
    }
}
