package ua.notebook_shop;


import java.sql.*;

public class DropAllTables {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/myunit", "root", "root");

        Statement statement = connection.createStatement();

//        statement.execute("ALTER TABLE notebook DROP FOREIGN KEY ");
//        statement.execute("ALTER TABLE model DROP FOREIGN KEY ");
        statement.execute("DROP TABLE notebook ");
        statement.execute("DROP TABLE model ");
        statement.execute("DROP TABLE screen ");
        statement.execute("DROP TABLE hdd ");
        statement.execute("DROP TABLE processor ");

    }
}
