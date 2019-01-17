package tests;

import org.testng.annotations.Test;
import pages.Porsche718TrimSelectionPage;
import pages.PorscheHomePage;
import pages.PorscheVehicleModificationPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.TestBase;

import static org.testng.Assert.*;

public class BuyPorscheTests extends TestBase {
    private static String adPrice718CaymanModelS;

    /*
    1.Open browser
    2.Go to url “https://www.porsche.com/usa/modelstart/”
    3.Select model 718
    4.Remember the price of 718 Cayman Model S
    5.Click on 718 Cayman S
    6.Verify that Base price displayed on the page is same as the price from step 4
    7.Verify that Price for Equipment is 0
    8.Verify that total price is the sum of base price + Delivery, Processing and Handling Fee
     */
    @Test (priority = 1)
    public void goToPorscheModelsStartPage() {
        // 1. Open browser
        // 2. Go to url
        driver.get(ConfigurationReader.getProperty("porscheURL"));
        PorscheHomePage porscheHomePage = new PorscheHomePage();

        // 3. Select model 718
        porscheHomePage.toModel718PageLink.click();

        // 4. Remember the price of 718 Cayman Model S
        Porsche718TrimSelectionPage porsche718TrimSelectionPage = new Porsche718TrimSelectionPage();
        adPrice718CaymanModelS = porsche718TrimSelectionPage.modelPrice718CaymanS.getText();
        adPrice718CaymanModelS = adPrice718CaymanModelS.substring(
                adPrice718CaymanModelS.indexOf('$') + 2,
                adPrice718CaymanModelS.indexOf("*"));

        // 5.Click on 718 Cayman S
        porsche718TrimSelectionPage.modelName718CaymanS.click();
        BrowserUtilities.wait(2);
        BrowserUtilities.wait(14);

        PorscheVehicleModificationPage modPage = new PorscheVehicleModificationPage();
        // 6.Verify that Base price displayed on the page is same as the price from step 4
        assertEquals(modPage.priceBase.getText(),
                adPrice718CaymanModelS,
                "The Base Price is expected to be " + adPrice718CaymanModelS);
    }
}
