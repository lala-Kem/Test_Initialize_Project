package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class newStyleSingle {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.out.println("STARTING_SETUP..............");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void testDropdown(){
        driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
//

        WebElement dropdown= driver.findElement(By.xpath(("//div[contains(@class, ui) and child::input[@name='user']]")));
        dropdown.click();
        List<WebElement> dropdownList = dropdown.findElements(By.className("item"));
        dropdownList.forEach(e-> System.out.println(e.getText()));
        driver.findElement(By.xpath(("//div[@class='item' and @data-value='matt' ]"))).click();
        System.out.println("----"+dropdown.findElement(By.xpath("//input[@name='user']")).getAttribute("value"));
    }
}
