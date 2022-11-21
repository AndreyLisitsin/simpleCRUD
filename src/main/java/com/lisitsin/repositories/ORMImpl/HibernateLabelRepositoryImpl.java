package com.lisitsin.repositories.ORMImpl;

import com.lisitsin.models.Label;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.utils.HibernateSessionService;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateLabelRepositoryImpl implements LabelRepository {

    HibernateSessionService service = HibernateSessionService.getInstance();

    @Override
    @SneakyThrows
    public Label getById(Long id) {
        Session session = service.openSession();
        session.beginTransaction();
        Label label = session.createQuery("SELECT l FROM Label l left join fetch l.posts where l.id =: id", Label.class)
                .setParameter("id", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return label;
    }

    @Override
    @SneakyThrows
    public List<Label> getAll() {
        Session session = service.openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT DISTINCT l FROM Label l left join fetch l.posts", Label.class);
        List <Label> labels = query.list();
        session.getTransaction().commit();
        session.close();
        return labels;
    }

    @Override
    public Label save(Label label) {
        Session session = service.openSession();
        session.beginTransaction();
        session.save(label);
        session.getTransaction().commit();
        session.close();
        return label;
    }

    @Override
    public Label update(Label label) {
        Session session = service.openSession();
        session.beginTransaction();
        session.update(label);
        session.getTransaction().commit();
        session.close();
        return label;
    }

    @Override
    public void deleteById(Long id) {
        Session session = service.openSession();
        session.beginTransaction();
        Label labelFromDb = session.get(Label.class, id);
        session.remove(labelFromDb);
        session.getTransaction().commit();
        session.close();
    }
}
