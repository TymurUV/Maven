package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    private static final String jdbcURL = "jdbc:mysql://localhost/album";
    private static final String username = "root";
    private static final String password = "root";
    private static final String CREATE_CAR = "INSERT INTO cars (brand, model, year_of_production) VALUES (?, ?, ?)";
    private static final String READ_CAR = "SELECT * FROM cars";
    private static final String UPDATE_CAR = "UPDATE cars SET brand = ?, model = ?, year_of_production = ? WHERE id = ?";
    private static final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";

    public static void main(String[] args) {
        createCar("Ferrari", "F1", new Date(2000));
        readCar();
        updateCar(1, "Ferrari", "P-1000", new Date(2003));
        deleteCar(1);
        readCar();

    }

    private static void createCar(String brand, String model, Date yearOfProduction) {
        try {
            Class.forName("com.mysql.cl.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CAR);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setDate(3, (java.sql.Date) yearOfProduction);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void readCar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(READ_CAR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("===================");
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("brand"));
                System.out.println(resultSet.getString("model"));
                System.out.println(resultSet.getDate("presented_at"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateCar(int id, String brand, String model, Date yearOfProduction) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setDate(3, (java.sql.Date) yearOfProduction);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteCar(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
