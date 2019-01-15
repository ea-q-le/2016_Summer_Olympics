package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.NoSuchElementException;

public class MedalTablePage {
    public MedalTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private String URL = ConfigurationReader.getProperty("url");
    private String title = "2016 Summer Olympics - Wikipedia";

    @FindBy (css = ".wikitable.sortable.plainrowheaders.jquery-tablesorter")
    public WebElement medalTable;

    @FindAll(@FindBy (css = ".wikitable.sortable.plainrowheaders.jquery-tablesorter thead th"))
    public List<WebElement> medalTableHeadings;

    @FindAll(@FindBy (css = ".wikitable.sortable.plainrowheaders.jquery-tablesorter tbody tr"))
    public List<WebElement> medalTableRows;

    /**
     * Generates the List<WebElement> per the column heading passed as String.
     * Throws NoSuchElementException if no such heading exists in the table.
     *
     * @param columnHeading String representation of column heading
     * @return              List<WebElement> of given heading
     */
    public List<WebElement> medalTableColumnElements(String columnHeading) throws NoSuchElementException {
        String[] strArr = BrowserUtilities.elementsToStringArray(medalTableHeadings);
        int index = 0;
        boolean found = false;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(columnHeading)) {
                index = i+1;
                found = true;
                break;
            }
        }
        if (!found || index <= 0 || index >= 7) throw new NoSuchElementException("The table doesn't contain " + columnHeading + " as heading.");

        String retCSS = ".wikitable.sortable.plainrowheaders.jquery-tablesorter tbody td:nth-child(" + index;

        if (index == 2) retCSS = ".wikitable.sortable.plainrowheaders.jquery-tablesorter tbody th";

        return BrowserUtilities.cssToList(retCSS);
    }

    /**
     * Finds and returns the name of the country based on the parameters.
     *
     * @param criteriaColumnHeading The String of column heading that is the return is to be based on
     * @param ascending             If true, table goes from the lowest to the highest, otherwise if false
     * @param ranking               Define the ranking of the country being requested
     * @return                      String of the table content under NOC column per provided criteria
     */
    public String theMostCountry(String criteriaColumnHeading, boolean ascending, int ranking) {
        WebElement headerToClick = null;
        for (WebElement each : medalTableHeadings)
            if (each.getText().equals(criteriaColumnHeading))
                headerToClick = each;


        headerToClick.click();
        if (!ascending)
            headerToClick.click();

        List<WebElement> countries = medalTableColumnElements("NOC");

        return countries.get(ranking - 1).getText();
    }

    public String getURL() { return URL; }

    public String getTitle() { return title; }
}
