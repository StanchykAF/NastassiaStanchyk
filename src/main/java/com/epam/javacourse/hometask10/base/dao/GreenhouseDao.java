package com.epam.javacourse.hometask10.base.dao;

import com.epam.javacourse.hometask10.base.ConnectionManager;
import com.epam.javacourse.hometask10.base.models.Greenhouse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class GreenhouseDao implements Dao<Greenhouse>{
    @Override
    public Greenhouse get(int id) {
        String sql = "SELECT * FROM greenhouses WHERE id=?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Greenhouse(id,
                        resultSet.getString("name").trim(),
                        resultSet.getInt("gardener_id"));
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
    public List<Greenhouse> getAll() {
        String sql = "SELECT * FROM greenhouses;";
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Greenhouse> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Greenhouse(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("gardener_id")));
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
    public List<Greenhouse> getBetween(String column, int start, int end) {
        String sql = "SELECT * FROM greenhouses WHERE ? BETWEEN ? AND ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setInt(2, start);
            statement.setInt(3, end);
            ResultSet resultSet = statement.executeQuery();
            List<Greenhouse> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Greenhouse(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getInt("gardener_id")));
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
    public List<Greenhouse> getIn(String column, List<String> list) {
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (String o : list) {
            joiner.add(o);
        }
        String sql = "SELECT * FROM greenhouses WHERE ? IN " + joiner + ";";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            ResultSet resultSet = statement.executeQuery();
            List<Greenhouse> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Greenhouse(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getInt("gardener_id")));
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
    public List<Greenhouse> getLike(String column, String pattern) {
        String sql = "SELECT * FROM greenhouses WHERE ? LIKE ?;";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, column);
            statement.setString(2, pattern);
            ResultSet resultSet = statement.executeQuery();
            List<Greenhouse> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Greenhouse(resultSet.getInt("id"),
                        resultSet.getString("name").trim(),
                        resultSet.getInt("gardener_id")));
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
    public void add(Greenhouse object) {
        String sql = "INSERT INTO greenhouses VALUES (?, ?, ?);";
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
            statement.setInt(3, object.getGardenerId());
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
        String sql = "DELETE FROM greenhouses WHERE ? = ?;";
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
        String sql = "DELETE FROM greenhouses WHERE ? = ?;";
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
        String sql = "TRUNCATE TABLE greenhouses;";
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
        String sql = "UPDATE greenhouses SET ? = ?;";
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
        String sql = "UPDATE greenhouses SET ? = ?;";
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
