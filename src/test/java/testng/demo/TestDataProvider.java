package testng.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
//    WebDriver driver;
//
//    @BeforeTest()
//    public void setupBase() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//
//    @AfterTest
//    public void closeTest() {
//        driver.quit();
//    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{1, 2}};
    }

    @DataProvider(name = "info-user")
    public Object[][] dataProviderInfo() {
        return new Object[][]{{"Xuan Nguyen", 21, "Ha Noi", true}};
    }

    @Test(dataProvider = "data-provider")
    public void sumTest(int numberOne, int numberTwo) {
        System.out.println(numberOne);
        System.out.println(numberTwo);
        System.out.println(numberOne + numberTwo);
    }

    @Test(dataProvider = "info-user")
    public void infoUserDisplay(String username, int age, String address, boolean married) {
        System.out.println(String.format(
                "username: %s\n age: %d\n address: %s\n married: %b\n"
                , username
                , age
                , address
                , married
        ));
    }


}
