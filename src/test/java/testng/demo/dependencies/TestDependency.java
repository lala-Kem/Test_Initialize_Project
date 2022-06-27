package testng.demo.dependencies;

import org.testng.annotations.Test;

public class TestDependency {

    @Test
    public void testMethodBase() {
        System.out.println("---- Parent: testMethodBase");
    }

    @Test
    public void testMethodBase2() {
        System.out.println("---- Parent: testMethodBase2");
    }


    @Test(dependsOnMethods = {"testMethodBase","testMethodBase2"})
    public void testMethod() {
        System.out.println("Test method under testMethod");
    }
}
