package advantage.page.loadable.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.*;

public class FirstComponentPracticePage extends LoadableComponent<FirstComponentPracticePage> {

    private static final String URL = "https://google.com.vn";
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@jsname='VlcLAe']//input[@name='btnK']")
    private WebElement btnSearchPopup;

    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")
    private WebElement btnSearch;
    public FirstComponentPracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchText(String text){
        inputSearch.sendKeys(text);
//        inputSearch.sendKeys(Keys.ENTER);
        inputSearch.sendKeys(Keys.ESCAPE);
//        btnSearchPopup.click();
//            btnSearch.click();

        String locator = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator))).click();

        WebElement btn = btnSearch.isDisplayed() ? btnSearch : btnSearchPopup;
        String text2 = btnSearch.isDisplayed() ? "btnSearch" : "btnSearchPopup";
        System.out.println("button is selected: \n"+text2);
                        btn.click();
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.ENTER).build().perform();
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue(url.toLowerCase().contains("google"));
    }
}
