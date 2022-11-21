package com.lisitsin.repositories.ORMImpl;

import com.lisitsin.models.Post;
import com.lisitsin.models.Writer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HibernateWriterRepositoryImplTest {

    HibernateWriterRepositoryImpl repository = new HibernateWriterRepositoryImpl();

    @Test
    void getWriterById(){
        Writer writer = repository.getById(1L);
        System.out.println(writer);
        List<Post> posts = writer.getPosts();
        for (Post post : posts) {
            System.out.println(post);
            System.out.println(post.getLabels());
        }
    }

    @Test
    void getAllWriter(){
        List<Writer> writers = repository.getAll();
        writers.forEach(w -> System.out.println(w + "Посты: " + w.getPosts()));
    }

    @Test
    void saveWriter(){
        Writer writer = new Writer("Evgeny", "Onegin");
        repository.save(writer);
        System.out.println(writer);
    }

}