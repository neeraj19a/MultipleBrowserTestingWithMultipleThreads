
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {




    @Test
    public static void GOOGLE4() {
        System.out.println("Google4 Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
       /* System.out.println("Google4 Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google4 Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    */}

    @Test
    public static void YANDEX() {
        System.out.println("Yandex Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yandex.com");
      /*  System.out.println("Yandex Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Yandex");
        System.out.println("Yandex Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    */}
    @Test
    public static void Facebook() {
        System.out.println("Yandex Test Started! " + "Thread Id: " + Thread.currentThread().getId());
        driver.navigate().to("https://www.facebook.com");
      /*  System.out.println("Yandex Test's Page title is: " + driver.getTitle() + " " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Yandex");
        System.out.println("Yandex Test Ended! " + "Thread Id: " + Thread.currentThread().getId());
    */}
}