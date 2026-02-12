package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AllureCategoryWriter {

    public static void createCategories() {

        String categoriesJson = """
        [
          {
            "name": "Product defects",
            "matchedStatuses": ["failed"],
            "messageRegex": ".*AssertionError.*|.*Expected.*but.*|.*Validation failed.*"
          },
          {
            "name": "Automation issues",
            "matchedStatuses": ["failed"],
            "messageRegex": ".*NoSuchElementException.*|.*TimeoutException.*|.*StaleElementReferenceException.*|.*ElementNotInteractableException.*"
          },
          {
            "name": "Environment issues",
            "matchedStatuses": ["broken"],
            "messageRegex": ".*RuntimeException.*|.*Connection refused.*|.*Could not start a new session.*"
          }
        ]
        """;

        try {
            File file = new File("allure-results/categories.json");
            file.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(file);
            writer.write(categoriesJson);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}