package com.lisitsin.repositories.impl.mySqlImpl;

import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.WriterRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class MySQLWriterRepository implements WriterRepository {

    @SneakyThrows
    public MySQLWriterRepository(){
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Override
    @SneakyThrows
    public Writer getById(Long id) {
        List<Post> posts = new ArrayList<>();
        String SQL ="SELECT writer.id AS writer_id, first_name AS f, last_name AS l, post.id AS post_id, updated, created, content  FROM writer LEFT JOIN post on writer.id = post.writer_id WHERE writer.id = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "root", "Lisitsin031095");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        String firstName = null;
        String lastName = null;
        long writerId = 0;
        while (resultSet.next()) {
            writerId = resultSet.getLong("writer_id");
            firstName = resultSet.getString("f");
            lastName = resultSet.getString("l");
            long postId = resultSet.getLong("post_id");
            Date created = resultSet.getDate("created");
            Date updated = resultSet.getDate("updated");
            String content = resultSet.getString("content");
            posts.add(new Post(postId, content, created, updated, null ,writerId));
        }

        return new Writer(writerId, firstName, lastName, posts);
    }

    @Override
    @SneakyThrows
    public List<Writer> getAll() {
        Set<Writer> writers = new HashSet<>();
        Map<Post,List<Label>> postsMap = new HashMap<>();
        String SQL = "select w.id as writer_id, first_name, last_name, p.id as post_id, content, created, updated,  l.id as label_id, label_name" +
                " from writer as w\n" +
                "left join post as p on w.id = p.writer_id\n" +
                "left join post_label as pl on  p.id = pl.post_id\n" +
                "left join label as l on  pl.label_id = l.id\n" +
                "order by w.first_name;";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "root", "Lisitsin031095");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            long writer_id = resultSet.getLong("writer_id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            long post_id = resultSet.getLong("post_id");
            String content = resultSet.getString("content");
            Date created = resultSet.getDate("created");
            Date updated = resultSet.getDate("updated");
            long label_id = resultSet.getLong("label_id");
            String label_name = resultSet.getString("label_name");

            Writer writer = new Writer(writer_id, first_name, last_name, new ArrayList<>());
            Label label = new Label(label_id, label_name);
            Post post = new Post(post_id, content,created, updated, Collections.emptyList(), writer_id);
            writers.add(writer);

            if (postsMap.containsKey(post)) {
                List<Label> labels = new ArrayList<>(postsMap.get(post));
                labels.add(label);
                postsMap.replace(post, postsMap.get(post), labels);
            }
            else {
                postsMap.put(post, List.of(label));
            }
        }
        List<Writer> writerList = new ArrayList<>(writers);
        List<Post> postList = postsMap.entrySet()
                .stream()
                .map(k -> {
            Post post = k.getKey();
            post.setLabels(k.getValue());
            return post;})
                .filter(p -> p.getId() != 0)
                .collect(Collectors.toList());

        for (Post post : postList) {
            for (Writer writer : writerList) {
                if (writer.getId() == post.getWriter_id()){
                    writer.getPosts().add(post);
                }
            }
        }

        return writerList;
    }

    @Override
    @SneakyThrows
    public Writer save(Writer writer) {
        String SQL = "INSERT INTO writer (first_name, last_name) VALUES (?, ?)";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, writer.getFirstName());
        statement.setString(2, writer.getLastName());
        statement.executeUpdate();
        return null;
    }

    @Override
    @SneakyThrows
    public Writer update(Writer writer) {
        String SQL ="UPDATE writer SET first_name = ?, last_name =? WHERE id = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, writer.getFirstName());
        statement.setString(2, writer.getLastName());
        statement.setLong(3, writer.getId());
        statement.executeUpdate();
        return null;
    }

    @Override
    @SneakyThrows
    public void deleteById(Long id) {
        String SQL ="DELETE FROM writer WHERE id = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialweb", "****", "****");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
