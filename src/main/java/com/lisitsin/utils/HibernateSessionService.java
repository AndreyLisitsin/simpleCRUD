package com.lisitsin.utils;

import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.models.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionService {

    private static HibernateSessionService service = new HibernateSessionService();
    private SessionFactory factory = new Configuration()
            .addAnnotatedClass(Writer.class)
            .addAnnotatedClass(Label.class)
            .addAnnotatedClass(Post.class)
            .buildSessionFactory();

    private HibernateSessionService() {
    }

    public static HibernateSessionService getInstance(){
        return service;
    }

    public Session openSession(){
        return factory.openSession();
    }
}
