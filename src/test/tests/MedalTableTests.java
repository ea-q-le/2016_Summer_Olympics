package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MedalTablePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class MedalTableTests extends TestBase {
    MedalTablePage medalTablePage;

    @BeforeMethod
    public void setUpPages() {
        medalTablePage = new MedalTablePage();
    }
    @AfterMethod
    public void wrapUpPages() {
        medalTablePage = null;
    }

    /**
     * Test Case 1: SORT TEST
     * 1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table
     * 2. Verify that by default the Medal table is sorted by rank.
     *      To do that you need to capture all the cells in the Rank column and check if
     *      they are in ascending order
     * 3. Click link NOC.
     * 4. Now verify that the table is now sorted by the country names. To do that you need to
     *      capture all the names in the NOC column and check if they are in ascending/alphabetical
     *      order
     * 5. Verify that Rank column is not in ascending order anymore.
     */
    @Test (priority = 1)
    public void sortTest() {
        // 1. Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table
        driver.get(ConfigurationReader.getProperty("url"));

        // 2. Verify that by default the Medal table is sorted by rank.
            // a. Store the elements of Rank column in a String array
            String[] initialRanking = BrowserUtilities.elementsToStringArray(
                    medalTablePage.medalTableColumnElements("Rank") );
            // b. convert the String [] into int[] to help with comparison
            int[] initialRankingNumbers = BrowserUtilities.convertStringArrayToIntArray(initialRanking);
            // c. check for the int[] to be in ascending order
            for (int i = 0; i < initialRankingNumbers.length - 1; i++) {
                System.out.println(initialRankingNumbers[i] + " vs " + initialRankingNumbers[i+1]);
                assertTrue(initialRankingNumbers[i + 1] == initialRankingNumbers[i]+1);
            }

        // 3. Click link NOC
        driver.findElement(By.cssSelector(".wikitable.sortable.plainrowheaders.jquery-tablesorter thead th:nth-child(2)")).click();

        // 4. Now verify that the table is now sorted by the country names.
            // a. Store the elements of NOC column in a String array
            String[] initialCountryNames = BrowserUtilities.elementsToStringArray(
                    medalTablePage.medalTableColumnElements("NOC") );
            // b. Utilizing String's .compareTo() method, verify country names are listed alphabetically
            for (int i = 0; i < initialCountryNames.length - 1; i++) {
                System.out.println(initialCountryNames[i] + " vs " + initialCountryNames[i+1]);
                assertTrue(initialCountryNames[i].compareTo(initialCountryNames[i + 1]) < 1);
            }

        // 5. Verify that Rank column is not in ascending order anymore.
            // a. Store the elements of Rank column in a String array
            String[] ensuingRanking = BrowserUtilities.elementsToStringArray(
                    medalTablePage.medalTableColumnElements("Rank") );
            // b. convert the String [] into int[] to help with comparison
            int[] ensuingRankingNumbers = BrowserUtilities.convertStringArrayToIntArray(ensuingRanking);
            // c. check for the int[] to be in ascending order
            for (int i = 0; i < ensuingRankingNumbers.length - 1; i++) {
                System.out.println(ensuingRankingNumbers[i] + " vs " + ensuingRankingNumbers[i+1]);
                assertFalse(ensuingRankingNumbers[i + 1] == ensuingRankingNumbers[i]+1);
            }
    }

}
