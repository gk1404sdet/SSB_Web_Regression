package utilities;

import java.io.File;
import java.nio.file.*;
import java.util.Comparator;

public class AllureCleaner {

    public static void clean() {
        try {
            Path path = Paths.get("allure-results");

            if (Files.exists(path)) {
                Files.walk(path)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            }

            System.out.println("Allure results cleaned successfully");

        } catch (Exception e) {
            System.out.println("Failed to clean Allure results: " + e.getMessage());
        }
    }
}