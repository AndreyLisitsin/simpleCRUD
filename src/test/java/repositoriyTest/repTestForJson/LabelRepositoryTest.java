package repositoriyTest.repTestForJson;

import com.lisitsin.models.Label;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.repositories.impl.jsonImpl.JsonLabelRepositoryImpl;
import org.junit.jupiter.api.Test;

public class LabelRepositoryTest {


    LabelRepository labelRepository;

    @Test
    void saveLabel1(){
        labelRepository.save(new Label("Animals"));
    }
    @Test
    void saveLabel2(){
        labelRepository.save(new Label("Humor"));
    }
    @Test
    void saveLabel3(){
        labelRepository.save(new Label("Sport"));
    }
    @Test
    void getLabels(){
        labelRepository.getAll();
    }

    @Test
    void getLabelById(){
        labelRepository.deleteById(3L);
    }
    @Test
    void updateLabel(){

        Label label = new Label("Movie");
        label.setId(1L);
        labelRepository.update(label);
    }

    @Test
    void deleteLabel(){
        labelRepository.deleteById(3L);
    }
}
