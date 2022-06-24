package advantage.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Verify(title = "Log In", css="#user_login")
public class LoginPage {

    @FindBy(id = "user_login")
    WebElement user_login;

    @FindBy (id = "user_pass")
    WebElement user_pass;

    @FindBy (id = "wp-submit")
    WebElement submitBtn;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}