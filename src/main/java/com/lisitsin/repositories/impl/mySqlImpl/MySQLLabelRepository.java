package com.lisitsin.repositories.impl.mySqlImpl;

import com.lisitsin.CreateConnection;
import com.lisitsin.models.Label;
import com.lisitsin.repositories.LabelRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLLabelRepository implements LabelRepository {

    @Override
    @SneakyThrows
    public Label getById(Long id) {
        String SQL = "SELECT * FROM label where id = ?";
        Connection connection = CreateConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery(SQL);
        long labelId = resultSet.getLong("id");
        String labelName = resultSet.getString("name");
        return new Label(labelId, labelName);
    }

    @Override
    @SneakyThrows
    public List<Label> getAll() {
        List<Label> labels = new ArrayList<>();
        String SQL = "SELECT * FROM label";
        long labelId;
        String labelName;
        Connection connection = CreateConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                labelId = resultSet.getLong("id");
                labelName = resultSet.getString("name");
                labels.add(new Label(labelId, labelName));
            }
        return labels;
    }

    @Override
    @SneakyThrows
    public Label save(Label label) {
        String labelName = label.getName();
        String SQL = "INSERT INTO label (name) VALUES (?)";
        Connection connection = CreateConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, labelName);
        statement.executeUpdate();
        return label;
    }

    @Override
    @SneakyThrows
    public Label update(Label label) {
        String SQL = "UPDATE labels SET name = ? WHERE id = ?";
        Connection connection = CreateConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, label.getName());
        statement.setLong(2, label.getId());
        statement.executeUpdate();
        return label;
    }

    @Override
    @SneakyThrows
    public void deleteById(Long id) {
        String SQL = "DELETE FROM labels WHERE id = " + id;
        Connection connection = CreateConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL);
    }
}
