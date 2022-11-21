package com.lisitsin.repositories.ORMImpl;

import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.repositories.ORMImpl.HibernateLabelRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateLabelRepositoryImplTest {

    LabelRepository repository = new HibernateLabelRepositoryImpl();

    @Test
    void readOneLabel(){
        Label label = repository.getById(1L);
        System.out.println(label);

    }

    @Test
    void getListLabel(){
        List<Label> labels = repository.getAll();
        labels.forEach(System.out::println);
    }

    @Test
    void saveLabel(){
        Label label = repository.save(new Label("hobby"));
        System.out.println(label);
    }

    @Test
    void updateLabel(){
        Label label = repository.update(new Label(5L, "university"));
        System.out.println(label);
    }
}
