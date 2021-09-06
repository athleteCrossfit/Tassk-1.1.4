package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static Util instance = null;
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "1q2w3e4r";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

    public static Util getInstance() {

        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }

    public static Configuration getConnectionHibernate() {
        Configuration configuration = new Configuration();
        try {
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "1q2w3e4r");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configuration;
    }
}