package com.lisitsin.services.impl;

import com.lisitsin.models.Post;
import com.lisitsin.myAnnotations.DBService;
import com.lisitsin.myAnnotations.InjectByType;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQlPostRepository;
import com.lisitsin.services.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    @InjectByType
    private PostRepository postRepository;

    @Override
    public Post getById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.update(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
