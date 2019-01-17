package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PorscheHomePage {
    public PorscheHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private String URL = "https://www.porsche.com/usa/modelstart/";
    private String title = "Porsche Car Configurator - Porsche USA";

    @FindBy (linkText = "Porscheusa.com")
    public WebElement toMainPageLink;

    @FindBy (linkText = "My Porsche")
    public WebElement toMyPorschePageLink;

    @FindBy (partialLinkText = "Login")
    public WebElement toLoginPageLink;

    @FindBy (css = "a[href='/usa/modelstart/all/?modelrange=718']")
    public WebElement toModel718PageLink;



    public String getURL() {
        return URL;
    }
    public String getTitle() {
        return title;
    }
}
