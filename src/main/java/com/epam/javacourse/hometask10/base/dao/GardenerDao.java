package com.epam.javacourse.hometask10.base.dao;

import com.epam.javacourse.hometask10.base.ConnectionManager;
import com.epam.javacourse.hometask10.base.models.Gardener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class GardenerDao implements Dao<Gardener>{
    @Override
    public Gardener get(int id) {
        String sql = "SELECT * FROM gardeners WHERE id=?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Gardener(id,
                        resultSet.getString("name").trim());
            } else {
                System.out.println("No result found for ID: " + id);
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
    public List<Gardener> getAll() {
        String sql = "SELECT * FROM gardeners;";
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Gardener> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Gardener(resultSet.getInt("id"),
                        resultSet.getString("name").trim()));
            }
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Gardener> getBetween(String column, int start, int end) {
        String sql = "SELECT * FROM gardeners WHERE ? BETWEEN ? AND ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setInt(2, start);
            statement.setInt(3, end);
            ResultSet resultSet = statement.executeQuery();
            List<Gardener> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Gardener(resultSet.getInt("id"),
                        resultSet.getString("name").trim()));
            }
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Gardener> getIn(String column, List<String> list) {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        for (String o : list) {
            joiner.add(o);
        }
        String sql = "SELECT * FROM gardeners WHERE ? IN " + joiner + ";";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            ResultSet resultSet = statement.executeQuery();
            List<Gardener> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Gardener(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public List<Gardener> getLike(String column, String pattern) {
        String sql = "SELECT * FROM gardeners WHERE ? LIKE ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setString(2, pattern);
            ResultSet resultSet = statement.executeQuery();
            List<Gardener> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Gardener(resultSet.getInt("id"),
                        resultSet.getString("name").trim()));
            }
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    @Override
    public void add(Gardener object) {
        String sql = "INSERT INTO gardeners VALUES (?, ?);";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
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
        String sql = "DELETE FROM gardeners WHERE ? = ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setString(2, value);
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
        String sql = "DELETE FROM gardeners WHERE ? = ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setInt(2, value);
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
        String sql = "TRUNCATE TABLE gardeners;";
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
        String sql = "UPDATE gardeners SET ? = ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setString(2, newValue);
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
        String sql = "UPDATE gardeners SET ? = ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setInt(2, newValue);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }
}
