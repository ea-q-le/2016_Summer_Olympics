package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    private Driver() {}

    public static WebDriver getDriver() {

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
