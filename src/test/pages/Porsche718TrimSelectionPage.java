package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Porsche718TrimSelectionPage {
    public Porsche718TrimSelectionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private String URL = "https://www.porsche.com/usa/modelstart/all/?modelrange=718";
    private String title = "Porsche Car Configurator - Porsche USA";

    @FindBy(linkText = "Porscheusa.com")
    public WebElement toMainPageLink;

    @FindBy (linkText = "My Porsche")
    public WebElement toMyPorschePageLink;

    @FindBy (partialLinkText = "Login")
    public WebElement toLoginPageLink;

    @FindBy (css = "#s718-cayman-models:last-of-type")
    public WebElement to718CaymanModelsPage;

    @FindBy (xpath = "(//*[@class='m-14-model-name'])[1]")
    public WebElement modelName718Cayman;
    @FindBy (xpath = "(//*[@class='m-14-model-price'])[1]")
    public WebElement modelPrice718Cayman;

    @FindBy (xpath = "(//*[@class='m-14-model-name'])[2]")
    public WebElement modelName718CaymanS;
    @FindBy (xpath = "(//*[@class='m-14-model-price'])[2]")
    public WebElement modelPrice718CaymanS;

    public String getURL() {
        return URL;
    }
    public String getTitle() {
        return title;
    }
}
