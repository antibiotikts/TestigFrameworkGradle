
import general.GeneralActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.found_products_page.FoundProductsPage;
import pages.home_page.HomePage;

import static constants.Url.ROZETKA;

public class BaseTest {
    protected WebDriver driver = GeneralActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected FoundProductsPage foundProductsPage = new FoundProductsPage(driver);

    @Before
    public void openBrowser() {
        basePage.open(ROZETKA);
    }

    @After
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

}
