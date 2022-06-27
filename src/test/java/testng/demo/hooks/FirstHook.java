package testng.demo.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class FirstHook {
   protected WebDriver driver;

//    @BeforeTest()
//    public void setupBase() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//
//    @AfterTest
//    public void closeTest() {
//        driver.quit();
//    }

    @BeforeClass
    public void setupBase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void closeTest() {
        driver.quit();
    }
}
