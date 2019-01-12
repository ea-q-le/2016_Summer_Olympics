package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MedalTablePage {
    public MedalTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = ".wikitable.sortable.plainrowheaders.jquery-tablesorter")
    public WebElement medalTable;

    @FindAll({
            @FindBy (css = ".wikitable.sortable.plainrowheaders.jquery-tablesorter"),
//            @FindBy (css = "thead"),
//            @FindBy (css = "th")
            })
    public List<WebElement> medalTableHeading;

    @FindBy (css = ".wikitable.sortable.plainrowheaders.jquery-tablesorter tbody tr")
    public List<WebElement> medalTableRows;

    public List<WebElement> medalTableColumns(String columnHeading) {



        return null;
    }
}
