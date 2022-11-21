package com.lisitsin.repositories.jdbcImpl;

import com.lisitsin.utils.ConnectionUtil;
import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.repositories.PostRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JDBCPostRepository implements PostRepository {

    ConnectionUtil connectionUtil = ConnectionUtil.GetConnectionUtil();

    private List<Post> getListOfPosts(ResultSet resultSet) throws SQLException {
        Map<Post, List<Label>> postListMap = new HashMap<>();
        /*while (resultSet.next()) {
            Long post_id = resultSet.getLong("post_id");
            String content = resultSet.getString("content");
            Date created = resultSet.getDate("created");
            Date updated = resultSet.getDate("updated");
            Long writer_id = resultSet.getLong("writer_id");
            Long labelId = resultSet.getLong("label_id");
            String label_name = resultSet.getString("label_name");
            Post post = new Post(post_id, content, created, updated, writer_id);
            Label label = new Label(labelId, label_name);
            if (postListMap.containsKey(post)){
                List<Label> labels = new ArrayList<>(postListMap.get(post));
                labels.add(label);
                postListMap.replace(post, postListMap.get(post), labels);
            }
            else {
                postListMap.put(post, List.of(label));
            }
        }*/
        List<Post> posts = postListMap.entrySet().stream()
                .map(e -> {
                    Post post = e.getKey();
                    post.setLabels(e.getValue());
                    return post;
                }).filter(p -> p.getId() != 0).collect(Collectors.toList());
        return posts;
    }

    @Override
    @SneakyThrows
    public Post getById(Long id) {

        String SQL = "select content, created, updated, writer_id, post_id, label_id, label_name from post as p\n" +
                "left join post_label as pl on p.id = pl.post_id\n" +
                "left join label as l on pl.label_id = l.id\n" +
                "where p.id = ?;";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery(SQL);
        return getListOfPosts(resultSet).get(0);
    }

    @Override
    @SneakyThrows
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        String SQL = "select content, created, updated, writer_id, post_id, label_id, label_name from post as p\n" +
                "left join post_label as pl on p.id = pl.post_id\n" +
                "left join label as l on pl.label_id = l.id; ";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();
        return getListOfPosts(resultSet);
    }

    @Override
    @SneakyThrows
    public Post save(Post post) {
        String SQL  = "INSERT INTO post (content, created, updated, writer_id) VALUES (?, ?, ?, ?);";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, post.getContent());
        statement.setDate(2, (Date) post.getCreated());
        statement.setDate(3, (Date) post.getUpdated());
      //  statement.setLong(4, post.getWriterId());
        statement.executeUpdate();

        SQL ="INSERT INTO post_label VALUES (?, ?);";
        PreparedStatement statement1 = connection.prepareStatement(SQL);
        List<Label> labels = post.getLabels();
        for (Label label : labels) {
            statement1.setLong(1, post.getId());
            statement1.setLong(2, label.getId());
            statement1.executeUpdate();
        }
        return post;
    }

    @Override
    @SneakyThrows
    public Post update(Post post) {
        String SQL = "UPDATE post SET content = ?, updated = ? WHERE id = ?;";
        Connection connection = connectionUtil.getConnection();
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
        String SQL = "DELETE FROM post WHERE id = ?;";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
