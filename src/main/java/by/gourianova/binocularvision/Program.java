package by.gourianova.binocularvision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        //java -classpath c:\Java\mysql-connector-java-8.0.11.jar;c:\Java Program
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");

            String url = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";


            try (Connection conn = DriverManager.getConnection(url, username, "778899")){

                Statement statement = conn.createStatement();
                // создание таблицы
          //      statement.executeUpdate(sqlCommand);

                System.out.println("Database has been created!");

            }


        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
