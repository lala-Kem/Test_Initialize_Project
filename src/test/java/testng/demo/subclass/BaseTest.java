package testng.demo.subclass;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeClass
    public void beforeBaseClass() {
        System.out.println("-------Parent Before Class ");
    }

    @AfterClass
    public void afterBaseClass() {
        System.out.println("-------Parent After Class ");
    }

    @BeforeMethod
    public void beforeBaseMethod() {
        System.out.println("-------Parent Before method");
    }

    @AfterMethod
    public void afterBaseMethod() {
        System.out.println("-------Parent After method");
    }


    @BeforeTest
    public void beforeTestParentMethod() {
        System.out.println("------Parent Before Test");
    }

    @AfterTest
    public void afterTestParentMethod() {
        System.out.println("------Parent After Test");
    }

}