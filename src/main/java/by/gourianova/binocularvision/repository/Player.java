package by.gourianova.binocularvision.repository;

import java.sql.SQLException;

public class Player extends User implements TableOperations {

        public Player() throws SQLException {
            super("player_table");
        }
/*
        @Override
        public void createTable() throws SQLException {
            super.executeSqlStatement("CREATE TABLE IF NOT EXISTS user_table(" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "login STRING NOT NULL," +
                    "create_time TIMESTAMP NOT NULL" +
                     "update_time TIMESTAMP NOT NULL" +
                    ")", "Создана таблица " + tableName);

        }

        @Override
        public void createForeignKeys() throws SQLException {
            super.executeSqlStatement(" ALTER TABLE player_table ADD FOREIGN KEY (login) REFERENCES result_table(login)",
                    "Cоздан внешний ключ person. -> person.id");
        }

        @Override
        public void createExtraConstraints() throws SQLException {


        }*/
    }
//}
