package org.org;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class Main {

    private static String DB_USERNAME = "postgres";
    private static String DB_PASSWORD = "root";
    private static String DB_URL = "jdbc:postgresql://127.0.0.1:5432/my_db";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        Calendar instance = Calendar.getInstance();
        Date date = new Date();
        instance.setTime(date); //устанавливаем дату, с которой будет производить операции
        List<Integer> listDate = Arrays.asList(0,24,24,24,24);
        List<Integer> listCount = Arrays.asList(195,45,20,20,20);
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd.HH");
        for(int i=0;i<5;i++){
            instance.add(Calendar.HOUR_OF_DAY, listDate.get(i));
            Date newDate = instance.getTime();
            String dateCon =  formatForDateNow.format(newDate);
            Telegram telegram = new Telegram();
            telegram.telegram("url",dateCon,listCount.get(i),1,false,connection);
        }

//        String SQL_TASK = "insert into maintable (date) values(?)";
//        try (final PreparedStatement statement = connection.prepareStatement(SQL_TASK))
//        {statement.setString(1, formatForDateNow.format(newDate));
//            statement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }
}


