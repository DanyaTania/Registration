package by.gourianova.binocularvision;


import by.gourianova.binocularvision.repository.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExchangeDB {
        public static final String DB_URL = "jdbc:h2:E:\\Program Files\\Web\\db\\exchange";
        public static final String DB_Driver = "org.h2.Driver";

        //SBD Tables
        User user;
        //Player player;



    // Получить новое соединение с БД
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL);

        }

        // Инициализация
        public ExchangeDB() throws SQLException, ClassNotFoundException { try {
            Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД

            Connection connection = DriverManager.getConnection(DB_URL);//соединениесБД
           // System.out.println("Соединение с СУБД выполнено.");
            connection.close();// отключение от БД

           // System.out.println("Отключение от СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();// обработка ошибки  Class.forName

            //System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection

            //   System.out.println("Ошибка SQL !");
        }


            // Инициализируем таблицы
            Connection connection =   DriverManager.getConnection(DB_URL);

            System.out.println("!!!Создана таблица " + connection.getClass().toString());
             //*/

            user=new User("player_table");
          //TODO: перенести на Sss - при регистрации нового пользователя
           // System.out.println("Создана таблица "+user.toString());
           // player=new Player();
            //TODO: перенести на login при первом запуске игры + потом каждый раз


        }


        // Создание всех таблиц и ключей между ними
        public void createTablesAndForeignKeys() throws SQLException {
          user.createTable();
         //    player.createTable();
       //    result.createTable();



        }

    public void setExchangeDB() {
                try{
                    ExchangeDB ExchangeDB = new ExchangeDB();
                    ExchangeDB.createTablesAndForeignKeys();
                } catch (SQLException e) {
                 //   e.printStackTrace();
                   System.out.println("SQL error!");
                } catch (ClassNotFoundException e) {
                    System.out.println("JDBC driver for SQL DBase note found!");
                }
            }



    public void Upend(){try {


        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO player_table ( PowerConsumption, NumberOfSpeakers, FrequencyRange,CordLength) VALUES (6,7,8,9)";
        int rowsAffected = ((Statement) statement).executeUpdate(sql);
        sql = "INSERT INTO speakers_table ( PowerConsumption, NumberOfSpeakers, FrequencyRange,CordLength) VALUES (443,3,4,5)";
        rowsAffected = rowsAffected+statement.executeUpdate(sql);
        System.out.println(rowsAffected + "!?!!");
        connection.close();
    }catch (SQLException e) {
     //       e.printStackTrace();
               System.out.println("SQL error!");
        }

    }
    }

