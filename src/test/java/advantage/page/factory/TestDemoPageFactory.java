package advantage.page.factory;

import advantage.page.factory.LoadingPageFactory;
import advantage.page.factory.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestDemoPageFactory {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.out.println("STARTING_SETUP..............");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void login_test(){

//        LoginPage login = new LoginPage(driver);
        LoginPage login = LoadingPageFactory.get(driver, LoginPage.class);
    }
}
