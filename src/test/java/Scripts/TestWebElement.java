package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v97.network.model.Headers;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;


public class TestWebElement {

    WebDriver driver;

    @Test(priority = 2)
    public void getWebElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/");

        //Set timeout

        WebElement element=driver.findElement(By.xpath("//h1[text()='HTML']//following-sibling::a[text()='Learn HTML']"));
        String className = element.getAttribute("class");
//        String color = element.getAttribute("background-color");
        System.out.println(String.format("className: %s",className));

        String color = element.getCssValue("background-color");
        System.out.println(String.format("className: %s",color));

        Dimension dimension = element.getSize();
        System.out.println(String.format("Height:   %s, Width:  %s",dimension.getHeight(),dimension.getWidth()));

        Point point = element.getLocation();
        System.out.println(String.format("X coordinate:   %s, y coordinate:  %s",point.getX(),point.getY()));

        List<WebElement> elementByLinkTexts= driver.findElements(By.linkText("Buy Certificate"));
        System.out.println("elementByLinkText- size:"+elementByLinkTexts.size());
        elementByLinkTexts.forEach(s-> {
            System.out.println("elementByLinkText-:  " + s);
            s.click();
        });

        System.out.println("=======================");
        Set<String> windows = driver.getWindowHandles();
        windows.forEach(w-> {
            System.out.println("window: " + w);
            System.out.println(driver.switchTo().window(w).getTitle());
        });






        Thread.sleep(2000);
        driver.quit();
    }


    @Test(priority = 1)
    public void useFrames() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        //Set timeout

        driver.switchTo().frame("iframeResult");
        driver.findElement(By.tagName("button")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text alert: "+alert.getText());;
        alert.accept();
        System.out.println("Title: "+driver.switchTo().defaultContent().getTitle());

        Thread.sleep(2000);
        driver.quit();

    }

    @Test(priority = 1)
    public void useSelects() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        //Set timeout

        Select select = new Select(driver.findElement(By.id("job1")));
        Thread.sleep(2000);
        driver.quit();

    }

    @Test(priority = 1)
    public void useActions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        // maximise the window

        // specify the URL of the webpage
        driver.get("https://www.google.com/");

        // specify the locator of the search box
        WebElement element = driver.findElement(
                By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));

        // create an object for the Actions class and pass the driver argument
        Actions action = new Actions(driver);

        // pass the product name that has to be searched in the website
        action.sendKeys(element, "Anh Tester").build().perform();

        Thread.sleep(2000);
        driver.quit();

    }

    @Test(priority = 1)
    public void usePopups() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");

        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Get all new opened tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Switch to Child window
                driver.switchTo().window(window);
                Thread.sleep(2000);
                System.out.println("Đã chuyển đến lớp Window con");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(1000);
                //Get text trang sau khi Submit
                System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());

                // Closing the Child Window.
                Thread.sleep(2000);
                driver.close();
            }
        }
        // Switching to Parent window (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        driver.quit();

    }


    @Test(priority = 1)
    public void useJavaScriptExecutor () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        // maximise the window

        // specify the URL of the webpage
        driver.get("https://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // specify the locator of the search box
        WebElement element = driver.findElement(
                By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));

        // create an object for the Actions class and pass the driver argument
        Actions action = new Actions(driver);

        // pass the product name that has to be searched in the website
        action.sendKeys(element, "Anh Tester").build().perform();

        Thread.sleep(2000);
        driver.quit();

    }

    @Test(priority = 1)
    public void findXpathDemo () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        // maximise the window

        // specify the URL of the webpage
        driver.get("https://demoqa.com/alerts");


        // specify the locator of the search box
        WebElement btnAlert = driver.findElement(
                By.id("promtButton"));
        btnAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(String.format("text: \n %s",alert.getText()));
        alert.sendKeys("Hello all!...");
        alert.accept();


        Thread.sleep(2000);
        driver.quit();

    }

    @Test(priority = 1)
    public void alertAuthenticate ()   {

        // Use webdrivermanager to handle chrome browser driver
        WebDriverManager.chromedriver().setup();

        // Start Chrome Browser
        ChromeDriver driver=new ChromeDriver();

        // Get devTools
        DevTools chromeDevTools=driver.getDevTools();

        // Create sessions
        chromeDevTools.createSession();

        // Enable network
        chromeDevTools.send(Network.enable(Optional.of(0), Optional.of(0), Optional.of(0)));

        // Create hashmap for storing key value pair
        Map<String, Object> header=new HashMap<>();

        // Create authentication string- please replace with your application username and password - in current case guest is username and password as well.
        String basicAuth ="Basic " + new String(new Base64().encode(String.format("%s:%s", "guest", "guest").getBytes()));

        // add Authorization as key and basicAuth as value
        header.put("Authorization", basicAuth);

        // add authentication as part of header
        chromeDevTools.send(Network.setExtraHTTPHeaders(new Headers(header)));

        // please replace this with your application url
        driver.get("https://jigsaw.w3.org/HTTP/");

        // click on link and your request should be authenticated
        driver.findElement(By.linkText("Basic Authentication test")).click();

    }

    @Test(priority = 1)
    public void alertAuthenticate2 () throws InterruptedException {

        // Use webdrivermanager to handle chrome browser driver
        WebDriverManager.chromedriver().setup();

        // Start Chrome Browser
        ChromeDriver driver=new ChromeDriver();

        // please replace this with your application url
        driver.get("https://jigsaw.w3.org/HTTP/");

        // click on link and your request should be authenticated
        driver.findElement(By.linkText("Basic Authentication test")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("guest" + Keys.TAB + "guest");
        driver.switchTo().alert().accept();
    }

    public void demoPageFactory () throws InterruptedException {

        // Use webdrivermanager to handle chrome browser driver
        WebDriverManager.chromedriver().setup();

        // Start Chrome Browser
        ChromeDriver driver=new ChromeDriver();

        // please replace this with your application url
        driver.get("https://jigsaw.w3.org/HTTP/");


    }
}