package sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OriginalStyle {
    WebDriver driver;

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
    public void testOldStyle() throws InterruptedException {
        // Initialize ChromeDriver
        // Here we assume that the ChromeDriver path has been set in the System Global variables

        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        //Create object of the Actions class
        Actions actions = new Actions(driver);


        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");


        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));

        currentAddress.sendKeys("43 School Lane London EC71 9GO");


        // Select the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

        // Copy the Current Address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();

        //Paste the Address in the Permanent Address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();


        //Compare Text of current Address and Permanent Address
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        Thread.sleep(5000);
        Assert.assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));


        driver.close();
    }
}
