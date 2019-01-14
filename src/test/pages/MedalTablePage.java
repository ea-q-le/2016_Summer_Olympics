package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

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

    //TODO
    public List<WebElement> medalTableColumnElements(String columnHeading) {
        WebDriver driver = Driver.getDriver();

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
        if (!found || index <= 0 || index >= 7) throw new RuntimeException("The table doesn't contain " + columnHeading + " as heading.");

        String retCSS = ".wikitable.sortable.plainrowheaders.jquery-tablesorter tbody td:nth-child(" + index;

        if (index == 2) retCSS = ".wikitable.sortable.plainrowheaders.jquery-tablesorter tbody th";

        return BrowserUtilities.cssToList(retCSS);
    }

    public String getURL() { return URL; }

    public String getTitle() { return title; }
}
