package Scripts;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestAttributeTest {

    @Test(expectedExceptions =IOException.class )
    public void exceptionTest() throws IOException {
        throw new IOException();
    }

    @Test(timeOut = 500)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(2000);
    }
}
