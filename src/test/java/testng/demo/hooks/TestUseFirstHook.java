package testng.demo.hooks;

import org.testng.annotations.Test;
import testng.demo.hooks.FirstHook;

public class TestUseFirstHook extends FirstHook {
    String url;

    @Test
    public void openDemoQa() throws InterruptedException {
        url = "https://demoqa.com/";
        driver.get(url);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
}
