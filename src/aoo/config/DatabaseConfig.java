package aoo.config;

import java.io.FileReader;
import java.util.Properties;

/**
 * Created by Juju on 4/19/2016.
 */
public class DatabaseConfig extends Properties {

    private static final String filename = "database.config";

    public DatabaseConfig() {
        try(FileReader fileReader = new FileReader(filename)) {
            super.load(fileReader);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to find " + filename, ex);
        }
    }

    public String getConnectionString() {
        return getProperty("connection-string");
    }

    public Properties getLoginProperties() {
        Properties properties = new Properties();
        properties.put("user", getUsername());
        properties.put("password", getPassword());
        return properties;
    }

    private String getUsername() {
        return getProperty("username");
    }

    private String getPassword() {
        return getProperty("password");
    }

}
