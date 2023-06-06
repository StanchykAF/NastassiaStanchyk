package com.epam.javacourse.hometask10.base.dao;

import com.epam.javacourse.hometask10.base.ConnectionManager;
import com.epam.javacourse.hometask10.base.models.Plant;
import com.epam.javacourse.hometask10.utils.StringUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlantsDao implements Dao<Plant>{
    @Override
    public Plant get(int id) {
        String sql = "SELECT * FROM plants WHERE id=?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name").trim();
                String type = resultSet.getString("type").trim();
                int foreignId = resultSet.getInt("greenhouse_id");
                resultSet.close();
                return new Plant(id, name, type, foreignId);
            } else {
                System.out.println("No result found for ID: " + id);
                resultSet.close();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Plant> getAll() {
        String sql = "SELECT * FROM plants";
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Plant> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Plant(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getString("type").trim(),
                        resultSet.getInt("greenhouse_id")));
            }
            resultSet.close();
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Plant> getBetween(String column, int start, int end) {
        String sql = "SELECT * FROM plants WHERE " + column + " BETWEEN ? AND ?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, start);
            statement.setInt(2, end);
            ResultSet resultSet = statement.executeQuery();
            List<Plant> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Plant(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getString("type").trim(),
                        resultSet.getInt("greenhouse_id")));
            }
            resultSet.close();
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Plant> getIn(String column, List<String> list) {
        String sql = "SELECT * FROM plants WHERE " + column + " IN " + StringUtils.joinerForInQuery(list);
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Plant> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Plant(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getString("type").trim(),
                        resultSet.getInt("greenhouse_id")));
            }
            resultSet.close();
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Plant> getLike(String column, String pattern) {
        String sql = "SELECT * FROM plants WHERE " + column + " LIKE ?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, pattern);
            ResultSet resultSet = statement.executeQuery();
            List<Plant> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Plant(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getString("type").trim(),
                        resultSet.getInt("greenhouse_id")));
            }
            resultSet.close();
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void add(Plant object) {
        String sql = "INSERT INTO plants VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
            statement.setString(3, object.getType());
            statement.setInt(4, object.getGreenhouseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void delete(String column, String value) {
        String sql = "DELETE FROM plants WHERE " + column + " = ?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void delete(String column, int value) {
        String sql = "DELETE FROM plants WHERE " + column + " = ?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void truncate() {
        String sql = "TRUNCATE TABLE plants";
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void update(String column, String newValue) {
        String sql = "UPDATE plants SET " + column + " = ?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, newValue);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void update(String column, int newValue) {
        String sql = "UPDATE plants SET " + column + " = ?";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, newValue);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }
}
