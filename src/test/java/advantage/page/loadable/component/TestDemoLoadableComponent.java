package advantage.page.loadable.component;

import advantage.page.factory.LoadingPageFactory;
import advantage.page.factory.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestDemoLoadableComponent {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.out.println("STARTING_SETUP..............");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login_test() throws InterruptedException {
        FirstComponentPracticePage page = new FirstComponentPracticePage(driver);
        page.get();
        page.searchText("Vietnamese");
        Thread.sleep(3000);

    }
}
