package com.lisitsin.repositories.ORMImpl;

import com.lisitsin.models.Post;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.utils.HibernateSessionService;
import lombok.SneakyThrows;
import org.hibernate.Session;

import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository {

    HibernateSessionService service = HibernateSessionService.getInstance();

    @Override
    @SneakyThrows
    public Post getById(Long id) {
        Session session = service.openSession();
        session.beginTransaction();
        Post post = session.createQuery("select p from Post p " +
                        "left join fetch p.labels " +
                        "left join fetch  p.writer " +
                        "where p.id =: id", Post.class)
                .setParameter("id", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    @SneakyThrows
    public List<Post> getAll() {
        Session session = service.openSession();
        session.beginTransaction();
        List <Post> posts = session.createQuery("select distinct p from Post p " +
                        "left join fetch p.labels " +
                        "left join fetch  p.writer")
                .list();
        session.getTransaction().commit();
        session.close();
        return posts;
    }

    @Override
    @SneakyThrows
    public Post save(Post post) {
        Session session = service.openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    @SneakyThrows
    public Post update(Post post) {
        Session session = service.openSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    @SneakyThrows
    public void deleteById(Long id) {
        Session session = service.openSession();
        session.beginTransaction();
        Post post = session.get(Post.class, id);
        session.remove(post);
        session.getTransaction().commit();
        session.close();
    }
}
