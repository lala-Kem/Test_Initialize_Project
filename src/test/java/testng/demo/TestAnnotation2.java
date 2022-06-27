package testng.demo;

import org.testng.annotations.*;

public class TestAnnotation2 {

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("1.-----------BeforeSuite");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("1.-----------AfterSuite");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("2.-----------BeforeTest");
    }


    @AfterTest
    public void AfterTest() {
        System.out.println("2.-----------AfterTest");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("3.-----------BeforeClass");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("3.-----------AfterClass");
    }

    @BeforeGroups(groups = {"testGroup1", "testGroup2"})
    public void BeforeGroups() {
        System.out.println("4.-----------BeforeGroups");
    }

    @AfterGroups
    public void AfterGroups() {
        System.out.println("5.-----------AfterGroups");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("5.-----------BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("5.-----------AfterMethod");
    }

    @Test
    public void testMethod1() {
        System.out.println("---------Test---------Method-1------------");
    }

    @Test
    public void testMethod2() {
        System.out.println("---------Test-----------Method-2----------");
    }

    @Test
    public void testGroup1() {
        System.out.println("---------Test-----------testGroup-1----------");
    }

    @Test
    public void testGroup2() {
        System.out.println("---------Test-----------testGroup-2----------");
    }
}
