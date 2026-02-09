package utilities;

import constants.Environment;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;

    public ConfigLoader() {
        String env = System.getProperty("env", "DEV");
        String path = switch (Environment.valueOf(env.toUpperCase())) {
            case PROD -> "src/test/resources/config/prodconfig.properties";
            default -> "src/test/resources/config/devconfig.properties";
        };
        properties = PropertyUtils.propertyLoader(path);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
