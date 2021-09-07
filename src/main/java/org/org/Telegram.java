package org.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Telegram {
    public void telegram(String url, String date, int count, int type, boolean done, Connection connection){
        // sql запрос, дата стринговая
        String sql = "INSERT INTO telegram (id, url, date, count, type, done) VALUES (DEFAULT, (?),(?),(?),(?),(?))";

        try (final PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, url);
            statement.setString(2, date);
            statement.setInt(3, count);
            statement.setInt(4, type);
            statement.setBoolean(5, false);

            //Cам запрос в базу.
            statement.executeUpdate();
            System.out.println("Для записи " + url + " добавлено задание категории " + type + " количество действий " + count + " время выполнения " + date);

        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
