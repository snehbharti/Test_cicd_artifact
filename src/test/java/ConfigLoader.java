import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader(String env) {
        try {       
            FileInputStream file = new FileInputStream("D:\\Job-3\\config\\"+env+".properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config for " + env, e);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
