package repositoriyTest.repTestForJson;

import com.lisitsin.models.Post;
import com.lisitsin.models.Writer;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQlPostRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JDBCTest {



    @Test
    void getAllWriters(){
        WriterRepository repository = new MySQLWriterRepository();
        List<Writer> all = repository.getAll();
        all.forEach(w -> System.out.println(w));
    }

    @Test
    void getAllPosts(){
        PostRepository repository = new MySQlPostRepository();
        List<Post> all = repository.getAll();
        all.forEach(p -> System.out.println(p));
    }
}
