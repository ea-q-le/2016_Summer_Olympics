package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PorscheVehicleModificationPage {
    public PorscheVehicleModificationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "#s_price .ccaRow:nth-of-type(1) .ccaPrice")
    public WebElement priceBase;

    @FindBy (css = "#s_price .ccaRow:nth-of-type(2) .ccaPrice")
    public WebElement priceEquipment;

    @FindBy (css = "#s_price .ccaRow:nth-of-type(3) .ccaPrice")
    public WebElement priceFees;

    @FindBy (css = "#s_price .ccaRow:nth-of-type(4) .ccaPrice")
    public WebElement priceTotal;
}
