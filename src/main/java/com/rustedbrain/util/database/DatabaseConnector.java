package com.rustedbrain.util.database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alexey on 11.06.2016.
 */
public class DatabaseConnector {

    private static final String DATABASE_URI = "postgres://bmhtrrhzyrzcbs:PYAaNSCUOYLJdRY8HZVyMpHMSO@ec2-54-228-219-2.eu-west-1.compute.amazonaws.com:5432/dcno72ka9tmgop";

    private static Connection getConnection(boolean isSSL) throws URISyntaxException, SQLException {
        URI dbUri = new URI(DATABASE_URI);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort()
                + dbUri.getPath();

        if (isSSL)
            dbUrl = dbUrl + "?sslmode=require&user=" + username + "&password=" + password;

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public static Connection getConnection() throws URISyntaxException, SQLException {
        return getConnection(false);
    }

    public static Connection getSSLConnection() throws URISyntaxException, SQLException {
        return getConnection(true);
    }

}
