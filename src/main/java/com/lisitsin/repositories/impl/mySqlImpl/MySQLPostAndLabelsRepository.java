package com.lisitsin.repositories.impl.mySqlImpl;

import com.lisitsin.ConnectionService;
import com.lisitsin.models.Label;
import com.lisitsin.myAnnotations.DBService;
import com.lisitsin.myAnnotations.InjectByType;
import com.lisitsin.myAnnotations.InjectProperty;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLPostAndLabelsRepository {

    @InjectByType
    private MySQlPostRepository postRepository;
    @InjectByType
    private MySQLLabelRepository labelRepository;

    @InjectByType
    ConnectionService service;

    @SneakyThrows
    List<Label> getLabelsByPostID(Long postId){
        List<Label> labels = new ArrayList<>();
        String SQL = "SELECT label_id FROM posts_labels WHERE post_id = ?";
        Connection connection = service.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, postId);
        ResultSet resultSet = statement.executeQuery();
        while ( resultSet.next()){
            labels.add(labelRepository.getById(resultSet.getLong("label_id")));
        }
        return labels;
    }



}
