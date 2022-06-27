package testng.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemoQaPage {
    WebDriver driver;
    String url;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openDemoQa() throws InterruptedException {
        url = "https://demoqa.com/";
        driver.get(url);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
