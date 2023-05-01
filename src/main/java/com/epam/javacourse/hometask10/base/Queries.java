package com.epam.javacourse.hometask10.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Queries {
    public void joinAllTheTables() {
        String sql = """
                SELECT * FROM plants LEFT JOIN (greenhouses, gardeners)
                ON (greenhouses.id = plants.greenhouse_id AND gardeners.id = greenhouses.gardener_id)
                ORDER BY plants.id""";
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf("%-5d%-20s%-20s%-5d%-5d%-20s%-5d%-5d%-20s%n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getString(9));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
    }

    public int getNumberOfRecords() {
        String sql = """
                SELECT SUM(total_count) AS total_count FROM (
                                       SELECT COUNT(id) AS total_count FROM plants
                                       UNION ALL
                                       SELECT COUNT(id) FROM greenhouses
                                       UNION ALL
                                       SELECT COUNT(id) FROM gardeners
                                   ) AS counts""";
        int result = 0;
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
        return result;
    }

    public List<String> getPlantsCountInTheGreenhouse() {
        String sql = """
                SELECT greenhouse_id, COUNT(id) AS plants_count
                FROM plants
                GROUP BY greenhouse_id""";
        List<String> result = new ArrayList<>();
        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(String.format("%-5d%-5d%n",
                        resultSet.getInt("greenhouse_id"),
                        resultSet.getInt("plants_count")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            ConnectionManager.closeConnection();
        }
        return result;
    }
}
