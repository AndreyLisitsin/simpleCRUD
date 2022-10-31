package repTest;

import com.lisitsin.cotrollers.LabelController;
import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.repositories.impl.jsonImpl.JsonPostRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class PostRepositoryTest {

    PostRepository repository = new JsonPostRepositoryImpl();
    LabelController labelController = new LabelController();

    @Test
    void save1(){
        Post post = new Post("This is the first post", new Date(), new Date(), labelController.getAll());
        System.out.println(repository.save(post));
    }

    @Test
    void save2(){
        Post post = new Post("This is the second post", new Date(), new Date(),List.of(labelController.save("Hobby"), labelController.save("Programming")));
        System.out.println(repository.save(post));
    }

    @Test
    void save3(){
        Post post = new Post("This is the third post", new Date(), new Date(), List.of(new Label("Pets"), labelController.getById(4L)));
        System.out.println(repository.save(post));
    }

    @Test
    void getById(){
        System.out.println(repository.getById(1L));
    }

    @Test
    void getAll(){
        System.out.println(repository.getAll());
    }

    @Test
    void update(){
        Post post = new Post("this is updated second post", repository.getById(2L).getCreated(), new Date(), repository.getById(2L).getLabels());
        post.setId(2L);
        repository.update(post);
    }

    @Test
    void delete(){
        repository.deleteById(3L);
    }
}
