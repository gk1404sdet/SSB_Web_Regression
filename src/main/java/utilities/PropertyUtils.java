package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {}

    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load properties file at: " + filePath, e
            );
        }

        return properties;
    }
}
