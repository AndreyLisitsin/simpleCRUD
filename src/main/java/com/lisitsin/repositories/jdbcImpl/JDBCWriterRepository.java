package com.lisitsin.repositories.jdbcImpl;

import com.lisitsin.utils.ConnectionUtil;
import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.models.Writer;
import com.lisitsin.repositories.WriterRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class JDBCWriterRepository implements WriterRepository {

    ConnectionUtil connectionUtil = ConnectionUtil.GetConnectionUtil();

    @Override
    @SneakyThrows
    public Writer getById(Long id) {

        String SQL ="SELECT writer.id AS writer_id, first_name AS f, last_name AS l, post.id AS post_id, updated, created, content" +
                "  FROM writer LEFT JOIN post on writer.id = post.writer_id WHERE writer.id = ?";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        return getWriterList(resultSet).get(0);
    }

    @Override
    @SneakyThrows
    public List<Writer> getAll() {

        String SQL = "select w.id as writer_id, first_name, last_name, p.id as post_id, content, created, updated,  l.id as label_id, label_name" +
                " from writer as w\n" +
                "left join post as p on w.id = p.writer_id\n" +
                "left join post_label as pl on  p.id = pl.post_id\n" +
                "left join label as l on  pl.label_id = l.id\n" +
                "order by w.first_name;";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery(SQL);

        return getWriterList(resultSet);
    }

    @Override
    @SneakyThrows
    public Writer save(Writer writer) {
        String SQL = "INSERT INTO writer (first_name, last_name) VALUES (?, ?)";
        Connection connection = connectionUtil.getConnection();
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
        Connection connection = connectionUtil.getConnection();
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
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
    }

    private static List<Writer> getWriterList(ResultSet resultSet) throws SQLException {
        Set<Writer> writers = new HashSet<>();
        Map<Post,List<Label>> postsMap = new HashMap<>();

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
                if (writer.getId() == post.getWriterId()){
                    writer.getPosts().add(post);
                }
            }
        }
        return writerList;
    }
}
