package tests;

import org.testng.annotations.Test;
import pages.MedalTablePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.TestBase;

import java.util.Arrays;

public class MedalTableTests extends TestBase {
    MedalTablePage medalTablePage;

    @Test (priority = 1)
    public void sortTest() {
        driver.get(ConfigurationReader.getProperty("url"));

//        String [] test = BrowserUtilities.elementsToStringArray(
                medalTablePage.medalTableHeading.get(3);
//    );

//        System.out.println(test.toString());
    }

}
