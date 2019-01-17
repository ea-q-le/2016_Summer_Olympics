package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

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

    /**
     * Accepts By element which is then converted within List<WebElement> and returned as
     * String[] of each element's text (by calling overloaded method)
     *
     * @param by    By object
     * @return      String [] of By object's elements' texts, stored individually
     */
    public static String[] elementsToStringArray(By by) {
        WebDriver driver = Driver.getDriver();

        List<WebElement> elements = driver.findElements(by);

        return elementsToStringArray(elements);
    }

    /**
     * Accepts List of WebElements and stores their text within String array, individually.
     *
     * @param elements  List<WebElement>
     * @return          String[] of each element's text
     */
    public static String[] elementsToStringArray(List<WebElement> elements) {
        String[] retArr = new String[elements.size()];

        int index = 0;
        for (WebElement each : elements)
            retArr[index++] = each.getText();

        return retArr;
    }

    /**
     * Accepts css locator as a String and returns the list of WebElements associated with it
     *
     * @param cssLocator    String representation of css locator
     * @return              List<WebElement>
     */
    public static List<WebElement> cssToList(String cssLocator) {
        WebDriver driver = Driver.getDriver();

        return driver.findElements(By.cssSelector(cssLocator));
    }

    /**
     * Accepts String[] elements of which are converted into Integer and returned as int[]
     * Conditions: if the String[] element contains any non-digit characters, the String will
     * be cut until that point and only then will be converted into Integer.
     * If the String[] element comes out to be empty, it will be stored as 0 (zero).
     *
     * @param strArr    String[] with digits
     * @return          int[] representation of String[] per conditions stated
     */
    public static int[] convertStringArrayToIntArray(String[] strArr) {
        int[] retArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            for (int y = 0; y < strArr[i].length(); y++) {
                if (!Character.isDigit(strArr[i].charAt(y)))
                    strArr[i] = strArr[i].substring(0, y);
                else
                    continue;
            }
            if (strArr[i].isEmpty())
                retArr[i] = 0;
            else
                retArr[i] = Integer.parseInt(strArr[i]);
        }

        return retArr;
    }

    /**
     * Accepts 2D String array. Assumes that the first element of each sub-array is country name
     * and the second element is the number of medals. Converts each second element into int and
     * returns one dimensional int array.
     *
     * @param str2D     Two dimensional String[][]
     * @return          int[]
     */
    public static int[] convert2DArray2ndArrayIntoIntArray(String[][] str2D) {
        int[] retArr = new int[str2D.length];

        for (int i = 0; i < retArr.length; i++) {
            for (int y = 0; y < str2D[i][1].length(); y++) {
                if (!Character.isDigit(str2D[i][1].charAt(y)))
                    str2D[i][1] = str2D[i][1].substring(0, y);
                else
                    continue;
            }
            if (str2D[i][1].isEmpty())
                retArr[i] = 0;
            else
                retArr[i] = Integer.parseInt(str2D[i][1]);
        }

        return retArr;
    }

    //TODO
    public static void windowSwitcher(int index) {
        WebDriver driver = Driver.getDriver();

        Set<String> handles = driver.getWindowHandles();

        int i = 1;
        for (String handle : handles)
            if (i++ == index)
                driver.switchTo().window(handle);
    }
}
