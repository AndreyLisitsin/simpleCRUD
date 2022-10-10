package repTest;

import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.JsonWriterRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class WriterRepositoryTest {

    WriterRepository writerRepository = new JsonWriterRepositoryImpl();

    @Test
    void read(){
        writerRepository.getAll();
    }

    @Test
    void saveWriter(){
        writerRepository.save(new Writer( "Roman", "Goncharenko", List.of(new Post("Another content",new Date(), new Date(), List.of(new Label("Movie"))))));
    }

    @Test
    void getWriterById(){
        writerRepository.getById(1L);
    }
}
