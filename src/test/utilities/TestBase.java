package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        BrowserUtilities.wait(3);
        Driver.closeDriver();
    }
}
