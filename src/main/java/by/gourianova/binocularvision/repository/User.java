package by.gourianova.binocularvision.repository;

import java.sql.SQLException;

public class User extends BaseTable implements TableOperations {

    public User(String player_table) throws SQLException {
        super("user_table");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS user_table(" +
                        "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "email STRING NOT NULL," +
                        "password STRING NOT NULL," +
                        "max_Result,"                +
                        "create_time TIMESTAMP NOT NULL" +
                        ")",
                "Создана таблица " + tableName);

    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement(" ALTER TABLE user_table ADD FOREIGN KEY (email),// REFERENCES player_table(login)",
                "Cоздан внешний ключ person. -> person.id");
    }

    @Override
    public void createExtraConstraints() throws SQLException {


    }
}