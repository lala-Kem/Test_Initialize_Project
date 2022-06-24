package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class multiSelectNewStyle {

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
    public void testDropdown(){
        driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'ui') and child::select[@name='skills']]"));
        dropdown.click();

//        Select select = new Select(dropdown.findElement(By.name("skills")));
//        select.selectByIndex(5);
//        System.out.println("VALUE:----"+select.getFirstSelectedOption().getText());
        List<WebElement> dropdownList = dropdown.findElements(By.className("item"));
        dropdownList.forEach(e-> System.out.println(e.getText()));
        System.out.println("============");
        dropdown.findElement(By.xpath("//div[@data-value='ruby']")).click();
        dropdown.findElement(By.xpath("//div[@data-value='ui']")).click();
        dropdown.findElement(By.xpath("//div[@data-value='ux']")).click();

        List<WebElement> selectedList= dropdown.findElements(By.xpath("//i[@class='dropdown icon']/following-sibling::a[@data-value and contains(@class,'transition')]"));
        selectedList.forEach(e-> System.out.println(e.getText()));
        selectedList.forEach(e->e.findElement(By.className("delete")).click());

    }
}
