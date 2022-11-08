package com.lisitsin.repositories.impl.mySqlImpl;

import com.lisitsin.ConnectionService;
import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.myAnnotations.InjectByType;
import com.lisitsin.myAnnotations.InjectProperty;
import com.lisitsin.repositories.PostRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySQlPostRepository implements PostRepository {

    @InjectByType
    ConnectionService service;

    @Override
    @SneakyThrows
    public Post getById(Long id) {
        String SQL = "SELECT * FROM POST WHERE id = ?";
        Connection connection = service.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery(SQL);
        String content = resultSet.getString("content");
        long idFromDataBase = resultSet.getLong("id");
        Date created = resultSet.getDate("created");
        Date updated = resultSet.getDate("updated");
        long writer_id = resultSet.getLong("writer_id");



        // inder review
        List<Label> labels = Collections.emptyList();
        return new Post(idFromDataBase, content,created, updated, labels, writer_id);
    }

    @Override
    @SneakyThrows
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        String SQL = "SELECT * FROM labels ";
        Connection connection = service.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String content = resultSet.getString("content");
            long idFromDataBase = resultSet.getLong("id");
            Date created = resultSet.getDate("created");
            Date updated = resultSet.getDate("updated");
            long writer_id = resultSet.getLong("writer_id");




            // inder review
            List<Label> labels = Collections.emptyList();
            posts.add(new Post(idFromDataBase, content,created, updated, labels, writer_id));
        }
        return posts;
    }

    @Override
    @SneakyThrows
    public Post save(Post post) {
        String SQL  = "INSERT INTO post (content, created, updated, writer_id) VALUES (?, ?, ?, ?)";
        Connection connection = service.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, post.getContent());
        statement.setDate(2, (Date) post.getCreated());
        statement.setDate(3, (Date) post.getUpdated());
        statement.setLong(4, post.getWriter_id());
        statement.executeUpdate();
        return post;
    }

    @Override
    @SneakyThrows
    public Post update(Post post) {
        String SQL = "UPDATE post SET content = ?, updated = ? WHERE id = ?";
        Connection connection = service.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, post.getContent());
        statement.setDate(2,(Date) post.getUpdated());
        statement.setLong(3, post.getId());
        statement.executeUpdate();
        return post;
    }

    @Override
    @SneakyThrows
    public void deleteById(Long id) {
        String SQL = "DELETE FROM post WHERE id =?";
        Connection connection = service.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
