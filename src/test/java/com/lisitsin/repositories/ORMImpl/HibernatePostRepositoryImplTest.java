package com.lisitsin.repositories.ORMImpl;

import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.models.Writer;
import com.lisitsin.repositories.PostRepository;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HibernatePostRepositoryImplTest {

    PostRepository repository = new HibernatePostRepositoryImpl();

    @Test
    void getById() {
        Post post = repository.getById(3L);
        System.out.println(post.getWriter());
        System.out.println(post.getLabels());
    }

    @Test
    void getAll() {
        List<Post> posts = repository.getAll();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    void save() {
        Post post = new Post("Как правильно следить за режимом сна", new Date(), new Date(),List.of(new Label("Health"), new Label(6L, "sport")),
                new Writer(1L,"Andrey", "Lisitsin"));
        repository.save(post);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}