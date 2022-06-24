package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBrokenLinksImages {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testBrokenLinks() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> elementList = driver.findElements(By.tagName("img"));
        System.out.println("Total number of links: " + elementList.size());
        elementList.forEach(e -> {
            try {
                verifyLink(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void verifyLink(WebElement e) throws IOException, InterruptedException {
        String link = e.getAttribute("src");
        HttpClient client = HttpClient.newBuilder().build();
        boolean isBroken = false;
        boolean serverError = false;
        if (link != null) {
            HttpRequest request = HttpRequest.newBuilder(URI.create(link)).build();
            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
            int status = response.statusCode();
            switch (status / 100) {
                case 4:
                    isBroken = true;
                    break;
                case 5:
                    serverError = true;
                    break;
            }
            System.out.println("Link:::::::::" + link + ":::status :::::" + status + "::::isBroken link:::::" + isBroken + "::: got server error:::::" + serverError);
        }

    }
}
