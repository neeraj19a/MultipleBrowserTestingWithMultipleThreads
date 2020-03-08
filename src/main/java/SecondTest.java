
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SecondTest extends BaseTest {


    @Test
    public static void GOOGLE4() {
        System.out.println("Google4 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
    }

    @Test
    public static void YANDEX() {
        System.out.println("Yandex Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yandex.com");
    }

    @Test
    public static void Facebook() {
        System.out.println("Facebook Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("https://www.facebook.com");
    }

    @Test
    public static void Yahoo() {
        System.out.println("Yahoo  Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("https://www.yahoo.com");
    }


}