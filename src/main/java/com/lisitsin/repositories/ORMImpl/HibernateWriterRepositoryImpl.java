package com.lisitsin.repositories.ORMImpl;

import com.lisitsin.models.Writer;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.utils.HibernateSessionService;
import org.hibernate.Session;

import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository {

    private HibernateSessionService service = HibernateSessionService.getInstance();

    @Override
    public Writer getById(Long id) {
        Session session = service.openSession();
        session.beginTransaction();
        Writer writer = session.createQuery("select w from Writer w " +
                        "left join fetch w.posts " +
                        "where w.id =: id", Writer.class)
                .setParameter("id", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        Session session = service.openSession();
        session.beginTransaction();
        List<Writer> writers = session.createQuery("select distinct w from Writer w left join fetch w.posts", Writer.class).list();
        session.getTransaction().commit();
        session.close();
        return writers;
    }

    @Override
    public Writer save(Writer writer) {
        Session session = service.openSession();
        session.beginTransaction();
        session.save(writer);
        session.getTransaction().commit();
        session.close();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = service.openSession();
        session.beginTransaction();
        session.update(writer);
        session.getTransaction().commit();
        session.close();
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = service.openSession();
        session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        session.remove(writer);
        session.getTransaction().commit();
        session.close();
    }
}
