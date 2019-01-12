package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configs;

    static {
        try {
            String path = "configuration.properties";
            FileInputStream fileInputStream = new FileInputStream(path);

            configs = new Properties();
            configs.load(fileInputStream);

            fileInputStream.close();
        }catch (Exception e) {
            System.out.println("Exception caught while reading configs: " + e.getMessage());
        }
    }

    public static String getProperty(String keyName) {
        return configs.getProperty(keyName);
    }
}
