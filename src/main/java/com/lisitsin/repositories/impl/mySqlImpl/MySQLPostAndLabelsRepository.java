package com.lisitsin.repositories.impl.mySqlImpl;

import com.lisitsin.utils.ConnectionUtil;
import com.lisitsin.models.Label;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLPostAndLabelsRepository {

    private MySQlPostRepository postRepository;
    private MySQLLabelRepository labelRepository;
    ConnectionUtil connectionUtil = ConnectionUtil.GetConnectionUtil();

    @SneakyThrows
    public MySQLPostAndLabelsRepository() {
        postRepository =  new MySQlPostRepository();
        labelRepository = new MySQLLabelRepository();
    }

    @SneakyThrows
    List<Label> getLabelsByPostID(Long postId){
        List<Label> labels = new ArrayList<>();
        String SQL = "SELECT label_id FROM posts_labels WHERE post_id = ?";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, postId);
        ResultSet resultSet = statement.executeQuery();
        while ( resultSet.next()){
            labels.add(labelRepository.getById(resultSet.getLong("label_id")));
        }
        return labels;
    }
}
