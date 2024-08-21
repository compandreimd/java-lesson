package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    private Properties properties;
    private static ReadConfig instance;

    private ReadConfig() {
        File file = new File("src/test/resources/config.properties");
        try {
            FileInputStream inp = new FileInputStream(file);
            properties = new Properties();
            properties.load(inp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getValue(String key){
        return properties.getProperty(key);
    }


    public static ReadConfig getInstance() {
        if(instance == null)
            instance = new ReadConfig();
        return instance;
    }
}
