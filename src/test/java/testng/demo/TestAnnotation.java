package testng.demo;

import org.testng.annotations.*;

public class TestAnnotation {

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

    @BeforeGroups(groups = {"testOne"})
    public void BeforeGroups() {
        System.out.println("4.-----------BeforeGroups");
    }

    @AfterGroups(groups = {"testOne"})
    public void AfterGroups() {
        System.out.println("4.-----------AfterGroups");
    }

    @BeforeGroups(groups = {"testTwo"})
    public void BeforeGroups2() {
        System.out.println("4.-----------BeforeGroups-testTwo");
    }

    @AfterGroups(groups = {"testTwo"})
    public void AfterGroups2() {
        System.out.println("4.-----------AfterGroups-testTwo");
    }


    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("5.-----------BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("5.-----------AfterMethod");
    }

    @Test(groups = {"testOne"})
    public void testMethod1() {
        System.out.println("---------Test---------Method-1------------");
    }

    @Test(groups = {"testTwo"})
    public void testMethod2() {
        System.out.println("---------Test-----------Method-2----------");
    }
}
