package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getPropertyObject() throws IOException {
        FileInputStream fs=new FileInputStream("src/main/resources/config.properties");
        Properties prop=new Properties();
        prop.load(fs);
        return prop;
    }

    public static String getUrl() throws IOException {
        return getPropertyObject().getProperty("url");
    }

    public static String getEmail() throws IOException {
        return getPropertyObject().getProperty("email");
    }

    public static String getPassword() throws IOException {
        return getPropertyObject().getProperty("password");
    }
}
