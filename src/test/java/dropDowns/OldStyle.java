package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OldStyle {
    WebDriver   driver;

    @BeforeTest
    public void setup(){
        System.out.println("STARTING_SETUP..............");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testOldStyle(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropdown);
//        select.selectByValue("2");
//        System.out.println(select.getFirstSelectedOption().getText());
//
//        select.selectByVisibleText("Option 1");
//        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
    }
}
