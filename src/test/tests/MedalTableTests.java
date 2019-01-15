package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MedalTablePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.TestBase;

import static org.testng.Assert.*;

public class MedalTableTests extends TestBase {
    MedalTablePage medalTablePage;

    @BeforeMethod
    public void setUpPages() {
        medalTablePage = new MedalTablePage();
        driver.get(ConfigurationReader.getProperty("url"));
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

    /**
     * Test Case 2: THE MOST
     * 1.Write a method that returns the name of the country with the greatest number of gold medals.
     * 2.Write a method that returns the name of the country with the greatest number of silver medals.
     * 3.Write a method that returns the name of the country with the greatest number of bronze medals.
     * 4.Write a method that returns the name of the country with the greatest number of medals.
     */
    @Test (priority = 2)
    public void theMost() {
        /*
        Developed a method that takes three parameters
        1. Column heading that is to be sorted (String, must match the heading exactly)
        2. Boolean for the table to be in ascending (smallest number first) or not (highest number first)
        3. Ranking (int) of the country that is seeked for
        The method will return the String that will be the name of the country (NOC) as seen on the table
         */
        String theMostGold = medalTablePage.theMostCountry("Gold", false, 1).trim();
        String theMostSilver = medalTablePage.theMostCountry("Silver", false, 1).trim();
        String theMostBronze = medalTablePage.theMostCountry("Bronze", false, 1).trim();
        String theMostTotal = medalTablePage.theMostCountry("Total", false, 1).trim();

        assertEquals(theMostGold, "United States (USA)", "gold case");
        assertEquals(theMostSilver, "United States (USA)", "gold case");
        assertEquals(theMostBronze, "United States (USA)", "gold case");
        assertEquals(theMostTotal, "United States (USA)", "gold case");
    }


}
