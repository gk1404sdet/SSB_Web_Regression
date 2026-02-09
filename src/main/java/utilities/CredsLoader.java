package utilities;

import java.io.InputStream;
import java.util.Properties;

public class CredsLoader {

    private final Properties props = new Properties();

    public CredsLoader() {
        loadCreds();
    }

    private void loadCreds() {
        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("credentials/creds.properties")) {

            if (is == null) {
                throw new RuntimeException(
                        "creds.properties not found under src/test/resources/credentials"
                );
            }

            props.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load creds.properties", e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}