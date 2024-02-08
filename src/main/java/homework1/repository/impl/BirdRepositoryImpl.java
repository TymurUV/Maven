package homework1.repository.impl;

import homework1.domain.Bird;
import homework1.repository.BirdRepository;
import homework1.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BirdRepositoryImpl implements BirdRepository {
    private final String create_Bird = "INSERT INTO bird (breed, name, discovered_at) VALUES (?, ?, ?)";
    private final String READ_ALL_BIRDS = "Select * FROM bird";
    private final String UPDATE_BIRD = "UPDATE bird SET breed = ?, name = ?, WHERE id = ?";
    private final String DELETE_BIRD_BY_ID = "DELETE FROM bird WHERE id = ?";
    private final Connection connection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;
    @Override
    public Bird create(Bird bird) {

        return null;
    }

    @Override
    public List<Bird> readAll() {
        List<Bird> birds = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL_BIRDS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Bird bird = Bird.

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Bird update(Bird bird) {
        return null;
    }

    @Override
    public void deleteByUd(Integer id) {

    }
}
