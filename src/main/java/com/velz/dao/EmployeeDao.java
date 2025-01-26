package com.velz.dao;

import com.velz.entity.Employee;
import com.velz.entity.EmployeeRank;
import com.velz.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao implements Dao<Integer, Employee> {
    private static final EmployeeDao DAO = new EmployeeDao();

    private static final String FIND_ALL = """
            SELECT id, name, rank FROM employee;
            """;

    private EmployeeDao() {}

    @Override
    public List<Employee> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (resultSet.next()) {
                 list.add(buildEmployee(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(Employee entity) {

    }
    public static EmployeeDao getInstance() {
        return DAO;
    }
    @Override
    public Employee save(Employee entity) {
        return null;
    }

    private Employee buildEmployee(ResultSet resultSet) throws SQLException {


        return new Employee(resultSet.getInt("id"),
                resultSet.getString("name"),
                EmployeeRank.valueOf(resultSet.getString("rank")));
    }
}

