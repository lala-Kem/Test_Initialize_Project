package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAlertPopup {
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

    @AfterTest
    public void closeTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        find to btn 'Click for JS Alert' and click
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

//        switch to alert window
        Alert alert = driver.switchTo().alert();

//        print text in alert
        System.out.println(alert.getText());

//        accept alert
        alert.accept();

//        find element has id ='result'
        WebElement result = driver.findElement(By.id("result"));

//        print text of result
        System.out.println(result.getText());

        System.out.println("=======Click for JS Confirm===========");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        System.out.println(result.getText());

        System.out.println("===========Click for JS Prompt==========");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("What am i doing here???????");
        alert3.accept();
        System.out.println(result.getText());
    }
}
