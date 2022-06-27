package testng.demo.subclass;

import org.testng.annotations.*;

public class TestClass extends BaseTest{
    @BeforeClass
    public void beforeChildClass() {
        System.out.println("Child Before Class ");
    }

    @AfterClass
    public void afterChildClass() {
        System.out.println("Child After Class ");
    }

    @BeforeMethod
    public void beforeChildMethod() {
        System.out.println("Child Before method");
    }

    @AfterMethod
    public void afterChildMethod() {
        System.out.println("Child After method");
    }

    @BeforeTest
    public void beforeTestChildMethod() {
        System.out.println("Child Before Test");
    }

    @AfterTest
    public void afterTestChildMethod() {
        System.out.println("Child After Test");
    }

    @Test
    public void testMethod() {
        System.out.println("Test method under TestClass");
    }
}
