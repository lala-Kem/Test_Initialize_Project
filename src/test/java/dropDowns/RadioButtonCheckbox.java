package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonCheckbox {
    WebDriver   driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void testOldStyle(){
        driver.get("https://semantic-ui.com/modules/checkbox.html");



        WebElement radioBtn = driver.findElement(By.xpath("//label[contains(text(),'Once a day') and preceding-sibling::input[@name='example2']]"));
        radioBtn.click();

        WebElement checkedBtn = driver.findElement(By.xpath("//input[@name='example2'and following-sibling::label[contains(text(),'Once a day')]]"));
        System.out.println(checkedBtn.getAttribute("checked"));
        System.out.println(checkedBtn.isSelected());

        WebElement checkedBtn2 = driver.findElement(By.xpath("//input[@name='example2'and following-sibling::label[contains(text(),'Once a week')]]"));
        System.out.println(checkedBtn2.getAttribute("checked"));
        System.out.println("===================================");

        //Attribute  checked ="checked" -> isSelected = true
        Assert.assertTrue(checkedBtn.isSelected());
    }

    @Test
    public void testCheckBoxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and following-sibling::text()=' checkbox 1']"));
        checkbox.click();
        System.out.println(checkbox.isSelected());
//        checkbox.click();
//        System.out.println(checkbox.isSelected());

        List<WebElement> elementList = driver.findElements(By.tagName("input"));
        elementList.forEach(e-> System.out.println(e.isSelected()));
    }
//    //
}
