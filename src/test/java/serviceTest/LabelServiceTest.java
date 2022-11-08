package serviceTest;

import com.lisitsin.models.Label;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.services.LabelService;
import com.lisitsin.services.impl.LabelServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

public class LabelServiceTest {


    @Mock
    LabelRepository repository;
    LabelService service;

    public LabelServiceTest() {
        MockitoAnnotations.openMocks(this);
      //  this.service = new LabelServiceImpl(repository);
    }
    @Test
    void getLabelById(){
        Label expected = new Label(1L, "sport");

        given(repository.getById(1L)).willReturn(expected);

        Label actual = service.getById(1L);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllLabels(){
        Label firstLabel = new Label(1L, "sport");
        Label secondLabel = new Label(2L, "science");

        List<Label> expected = new ArrayList<>(List.of(firstLabel, secondLabel));

        given(repository.getAll()).willReturn(expected);

        List<Label> actual = service.getAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void saveOrUpdateLabel(){
        Label firstLabel = new Label(1L, "sport");

        given(repository.save(firstLabel)).willReturn(firstLabel);
        given(repository.update(firstLabel)).willReturn(firstLabel);

        Label save = service.save(firstLabel);
        Label update = service.update(firstLabel);

        Assertions.assertEquals(firstLabel, save);
        Assertions.assertEquals(firstLabel, update);
    }
}
