package todolist.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionConfig {

    private static final String PROPERTIES_FILE = "application.properties";

    public static Connection getConnection() {
        try (InputStream input = ConnectionConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            props.load(input);

            String url = String.format(
                "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
                props.getProperty("db.host"),
                props.getProperty("db.port"),
                props.getProperty("db.name")
            );

            return DriverManager.getConnection(url, props.getProperty("db.user"), props.getProperty("db.password"));

        } catch (Exception e) {
            throw new RuntimeException("❌ Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
