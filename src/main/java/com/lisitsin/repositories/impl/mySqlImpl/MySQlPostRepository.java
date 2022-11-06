package com.lisitsin.repositories.impl.mySqlImpl;

import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.repositories.PostRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQlPostRepository implements PostRepository {

    MySQLPostAndLabelsRepository postAndLabelsRepository = new MySQLPostAndLabelsRepository();

    @SneakyThrows
    public MySQlPostRepository(){
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Override
    @SneakyThrows
    public Post getById(Long id) {
        String SQL = "SELECT * FROM POST WHERE id = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery(SQL);
        String content = resultSet.getString("content");
        long idFromDataBase = resultSet.getLong("id");
        Date created = resultSet.getDate("created");
        Date updated = resultSet.getDate("updated");
        long writer_id = resultSet.getLong("writer_id");
        List<Label> labels = postAndLabelsRepository.getLabelsByPostID(id);
        return new Post(idFromDataBase, content,created, updated, labels, writer_id);
    }

    @Override
    @SneakyThrows
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        String SQL = "SELECT * FROM labels ";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String content = resultSet.getString("content");
            long idFromDataBase = resultSet.getLong("id");
            Date created = resultSet.getDate("created");
            Date updated = resultSet.getDate("updated");
            long writer_id = resultSet.getLong("writer_id");
            List<Label> labels = postAndLabelsRepository.getLabelsByPostID(idFromDataBase);
            posts.add(new Post(idFromDataBase, content,created, updated, labels, writer_id));
        }
        return posts;
    }

    @Override
    @SneakyThrows
    public Post save(Post post) {
        String SQL  = "INSERT INTO post (content, created, updated, writer_id) VALUES (?, ?, ?, ?)";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
