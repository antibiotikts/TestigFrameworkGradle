package pages.home_page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import java.time.Duration;
import static constants.Constant.WAITINGTIME;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By searchLine = By.xpath("//input[@name='search']");
    private final By searchButton = By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']");
    private final By loginButton = By.xpath("//button[@class='header__button ng-star-inserted']//*[@href='#icon-user-simple']");

    private final By loginField = By.id("auth_email");
    private final By passwordField = By.id("auth_pass");
    private final By loginEnterButton = By.xpath("button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");
    private final By catalogButton = By.id("fat-menu");
    private final By sneakers = By.xpath("//a[contains(@href, 'mugskie-krossovki')]");
    private final By shoesClothes = By.xpath("//a[contains(@href, 'shoes_clothes')]");
    private final By popup = By.xpath("//span[@class='exponea-close-cross']");

    public HomePage search() {
        driver.findElement(searchLine);
        return this;
    }

    public HomePage addSearchidProduct(String request) {
        driver.findElement(searchLine).sendKeys(request);
        return this;
    }

    public HomePage presSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public HomePage searchidByCatalog() {
        WebElement button = (new WebDriverWait(driver, Duration.ofSeconds(WAITINGTIME))
                .until(ExpectedConditions.elementToBeClickable(catalogButton)));
        button.click();
        WebElement shoesClothesMenu = (new WebDriverWait(driver, Duration.ofSeconds(WAITINGTIME))
                .until(ExpectedConditions.elementToBeClickable(shoesClothes)));
        Actions action = new Actions(driver);
        action.moveToElement(shoesClothesMenu);
        action.perform();
        WebElement searchidProduct = (new WebDriverWait(driver, Duration.ofSeconds(WAITINGTIME))
                .until(ExpectedConditions.elementToBeClickable(sneakers)));
        searchidProduct.click();
        return this;
    }
    public HomePage closePopup() {
        WebElement element = (new WebDriverWait(driver,Duration.ofSeconds(WAITINGTIME)))
                .until(ExpectedConditions.elementToBeClickable(popup));
        element.click();
        return this;
    }

    public HomePage waitPage() {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(WAITINGTIME))
                .until(ExpectedConditions.elementToBeClickable(loginButton)));
        return this;
    }
}
