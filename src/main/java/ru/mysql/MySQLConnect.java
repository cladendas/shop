package ru.mysql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class MySQLConnect {
     
    public static void main(String[] args) {


        System.out.println("------- Проверка подключения к MySQL -------");
         
        Connection connection = null;
        try {

            // подключение к базе с указанием протокола:подпротокола://[хоста]:[порта_СУБД]/[БД]
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testBase","root", "1234");

            System.out.println("------- Подключение установлено -------\n\n\n");

            // создание объекта для SQl запросов без параметров
            Statement statement = null;
            statement = connection.createStatement();

            // выполнение запроса на добавление данных
            statement.executeUpdate("INSERT INTO products VALUES('виноград','444','66')");

            // запрос на вывод всех столбцов таблицы products
            ResultSet rs = null;
            rs = statement.executeQuery("SELECT * FROM products");

            // переменная для хранения количества колонок в результирующем запросе
            int columns = rs.getMetaData().getColumnCount();

            // цикл для вывода каждой строки таблицы
            // метод next() используется для перехода к следующей строке
            while(rs.next()){
                for (int i = 1; i <= columns; i++){

                    // вывод данных каждого столбца-строки
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        if(null != connection) {
            System.out.println("------- СРАБОТАЛО!!!\nМАЗА ФАКА!!! -------");
        } else {
            System.out.println("------- Подключение НЕ установлено -------");
        }
    }
}