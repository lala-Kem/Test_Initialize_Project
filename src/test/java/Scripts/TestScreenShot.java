package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestScreenShot {
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
    public void testScreenShot(){
        driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");

//        declare TakeScreenShot and typecast driver
        TakesScreenshot shot = (TakesScreenshot) driver;

//        get the screenshot as File Object
        File file = shot.getScreenshotAs(OutputType.FILE);

//        serialize the file object by copying
        File dFile = new File("directory/screenshot1.jpg");
        File theDir = new File("directory");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        try {
            FileUtils.copyFile(file,dFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
