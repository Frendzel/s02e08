package io.github.javafaktura.s02e08.ctw;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceJdbc {

    private Connection connection;

    public void doSomeJDBC() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
