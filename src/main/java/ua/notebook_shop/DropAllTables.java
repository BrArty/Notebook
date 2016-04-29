package ua.notebook_shop;


import java.sql.*;

public class DropAllTables {

    public static void drop() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/myunit", "root", "root");

        Statement statement = connection.createStatement();

//        statement.execute("ALTER TABLE notebook DROP FOREIGN KEY ");
//        statement.execute("ALTER TABLE model DROP FOREIGN KEY ");

        // corrected remove tables... with your relations between tables - only in this sequence

        statement.execute("DROP TABLE Notebook ");
        statement.execute("DROP TABLE HDD ");
        statement.execute("DROP TABLE Model ");
        statement.execute("DROP TABLE Processor ");
        statement.execute("DROP TABLE RAM ");
        statement.execute("DROP TABLE Screen  ");
        statement.execute("DROP TABLE VideoMemory ");

    }
}
