package serviceTest;

import com.lisitsin.models.Writer;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.services.WriterService;
import com.lisitsin.services.impl.WriterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

public class WriterServiceTest {

    @Mock
    private MySQLWriterRepository writerRepository;

    private final WriterService writerService;

    public WriterServiceTest() {
        MockitoAnnotations.openMocks(this);
        writerService = new WriterServiceImpl(writerRepository);
    }

    @Test
    void getWriterById() {
        given(writerRepository.getById(1L)).willReturn(
                new Writer(1L, "firstName", "lastName"));
        Writer writer = writerService.getById(1L);
        Assertions.assertEquals(new Writer(1L,"firstName", "lastName"), writer);
    }
    @Test
    void getAllWriters(){
        given(writerRepository.getAll()).willReturn(List.of(
                new Writer(1L, "firstName", "lastName"),
                new Writer(2L, "SecondWriter", "SecondWriterLastname")));

        List<Writer> writers = writerService.getAll();
        Assertions.assertEquals(List.of(
                new Writer(1L, "firstName", "lastName", Collections.emptyList()),
                new Writer(2L, "SecondWriter", "SecondWriterLastname", Collections.emptyList())), writers);
    }

    @Test
    void saveOrUpdateWriter(){
        given(writerRepository.save(new Writer("Lev", "Tolstoy"))).willReturn(new Writer("Lev", "Tolstoy"));
        Writer save = writerService.save(new Writer("Lev", "Tolstoy"));
        Assertions.assertEquals(new Writer("Lev", "Tolstoy"), save);
    }

    @Test
    void deleteWriter(){
        // пока не придумал как удалять писателя
        List<Writer> writers = List.of(new Writer(1L,"Alexandr", "Pushkin"),
                new Writer(2L,"Fedor", "Dostoevsky"));
       // given(writerRepository.deleteById(1L)).willReturn(writers.stream().filter(w -> w.getId() != 1L).collect(Collectors.toList()));
    }
}
