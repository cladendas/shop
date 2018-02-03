package ru.mysql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class MySQLConnect {
     
    public static void main(String[] args) {



        System.out.println("------- Проверка подключения к MySQL -------");
         
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testBase","root", "1234");
            System.out.println("------- Подключение установлено -------\n\n\n");
            Statement statement = null;
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM products");

            int columns = rs.getMetaData().getColumnCount();
            while(rs.next()){
                for (int i = 1; i <= columns; i++){
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
         
        if(null != connection) {
            System.out.println("------- СРАБОТАЛО!!!\nМАЗА ФАКА!!! -------");
        } else {
            System.out.println("------- Подключение НЕ установлено -------");
        }
    }
}