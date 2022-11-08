package inversionOfControl;

import com.lisitsin.ConnectionService;
import com.lisitsin.configuration.ObjectFactory;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.services.WriterService;
import com.lisitsin.services.impl.WriterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IocTest {

    @Test
     void getClassByName(){
        try {
            Class<?> aClass = Class.forName("com.lisitsin.ConnectionService");
            System.out.println(aClass.getName());
            Object o = ObjectFactory.getInstance().createObject(aClass.getClass());
            ConnectionService service =(ConnectionService) o;
            Assertions.assertNotNull(service.getConnection());
        } catch (Exception e) {}

    }

    @Test
    void createWriterService(){
        WriterRepository repository = ObjectFactory.getInstance().createObject(WriterRepository.class);
        System.out.println(repository.getAll());
    }

}
