package org.org;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;;

public class Main {

    private static String DB_USERNAME = "postgres";
    private static String DB_PASSWORD = "root";
    private static String DB_URL = "jdbc:postgresql://127.0.0.1:5432/my_db";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        Calendar instance = Calendar.getInstance();
        Date date = new Date();
        instance.setTime(date); //устанавливаем дату, с которой будет производить операции
        instance.add(Calendar.HOUR_OF_DAY, 240);
        Date newDate = instance.getTime();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd.HH");
                // null () = new SimpleDateFormat("E yyyy.MM.dd ‘и время’ hh:mm:ss a zzz");

        System.out.printf(formatForDateNow.format(newDate));
        String SQL_TASK = "insert into maintable (date) values(?)";
        try (final PreparedStatement statement = connection.prepareStatement(SQL_TASK))
        {statement.setString(1, formatForDateNow.format(newDate));
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


