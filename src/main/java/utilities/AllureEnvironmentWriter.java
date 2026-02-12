package utilities;


import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class AllureEnvironmentWriter {

    public static void createEnvironment() {

        try {
            Properties props = new Properties();
            props.setProperty("Environment", "UAT");
            props.setProperty("Automation", "SSBeauty Web Regression");

            props.setProperty("Platform", "Web Application");
            props.setProperty("Browser Name", "Chrome");

            File file = new File("allure-results/environment.properties");
            file.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(file);
            props.store(writer, "Allure Environment Details");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}