package repositoriyTest.repTestForJson;

import com.lisitsin.cotrollers.PostController;
import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.models.Writer;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.jsonImpl.JsonPostRepositoryImpl;
import com.lisitsin.repositories.impl.jsonImpl.JsonWriterRepositoryImpl;
import com.lisitsin.services.impl.PostServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class WriterRepositoryTest {

    WriterRepository writerRepository;
    PostController postController;

    @Test
    void saveWriter(){
        writerRepository.save(new Writer( "Roman", "Goncharenko", List.of(new Post("Another content",new Date(), new Date(), List.of(new Label("Movie"))))));
    }

    @Test
    void gatAll(){
        writerRepository.getAll();
    }

    @Test
    void getWriterById(){
        writerRepository.getById(1L);
    }
    @Test
    void update(){
        Writer writer = new Writer("Roman","Ershov", postController.getPosts());
        writer.setId(2L);
        System.out.println(writerRepository.update(writer));
    }
    @Test
    void delete(){
        writerRepository.deleteById(1L);
    }
}
