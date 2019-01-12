package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtilities {

    /**
     * Simple Thread.sleep utilization method that stops the thread for
     * given number of seconds.
     *
     * @param seconds   to be multiplied by 1000 milliseconds
     */
    public static void wait(int seconds) {
        try { Thread.sleep(seconds * 1000); } catch (Exception e) { }
    }

    // TODO
    public static String[] elementsToStringArray(By by) {
        WebDriver driver = Driver.getDriver();

        List<WebElement> elements = driver.findElements(by);

        String[] retArr = new String[elements.size()];

        int index = 0;
        for (WebElement each : elements)
            retArr[index++] = each.getText();

        return retArr;
    }

    // TODO
    public static String[] elementsToStringArray(List<WebElement> elements) {
        String[] retArr = new String[elements.size()];

        int index = 0;
        for (WebElement each : elements) {
            System.out.println(each.getText());
            retArr[index++] = each.getText();
        }

        return retArr;
    }
}
