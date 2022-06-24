package advantage.page.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoadingPageFactory {

    public static <T> T get(WebDriver driver, Class<T> pageObjectClass) {
        Verify verify = pageObjectClass.getAnnotation(Verify.class);
        checkTitle(driver, verify);
        checkCss(driver, verify);
        return PageFactory.initElements(driver, pageObjectClass);
    }

    private static void checkCss(WebDriver driver, Verify verify) {
        String css = verify.css();
        if (!css.equals(Verify.INVALID_CSS)) {
            if (driver.findElements(By.cssSelector(css)).isEmpty()) {
                throw new IllegalStateException("expected CSS " + css);
            }
        }
    }

    private static void checkTitle(WebDriver driver, Verify verify) {
        String expectedTitle = verify.title();

        if (!expectedTitle.equals(Verify.INVALID_TITLE)) {
            String actualTitle = driver.getTitle();

            if (!expectedTitle.equals(actualTitle)) {
                throw new IllegalStateException(
                        String.format("expected page title %s but was %s",
                                expectedTitle,
                                actualTitle
                        )
                );
            }
        }
    }

}