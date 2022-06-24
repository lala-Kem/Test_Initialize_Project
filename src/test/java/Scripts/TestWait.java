package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TestWait {

    WebDriver driver;

    @Test(priority = 2)
    public void ExplicitWaitDemo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        driver.get("https://hrm.anhtester.com/");

        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Dự án')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}