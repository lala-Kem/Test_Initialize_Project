package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestWindowStyle {
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

    @Test()
    public void testWindowStyle() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowH3 = driver.findElement(By.tagName("h3")).getText();
        System.out.println(parentWindowH3);
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("WindowHandle:  " + parentWindowHandle);
        System.out.println("============================");

//        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();


//        Getting the handles/identifiers of all available windows
        Set<String> windowHandles = driver.getWindowHandles();
//        Switching to the child window
        for (String handle : windowHandles) {
            if (handle != parentWindowHandle) {
                driver.switchTo().window(handle);
                System.out.println("Switch window: " + handle);
            }
        }
        String childrenWindowH3 = driver.findElement(By.tagName("h3")).getText();
        String windowHandlePresent = driver.getWindowHandle();
        System.out.println("Present Window: " + windowHandlePresent);
        System.out.println(childrenWindowH3);
        driver.close();

        System.out.println("==== Switching back to parent window");
        driver.switchTo().window(parentWindowHandle);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }


}
