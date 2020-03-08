
import com.google.common.base.Strings;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest extends MultiThreadingExample {

    Thread t1 = new MultiThreadingExample();
    Thread t2 = new MultiThreadingExample();
    Thread t3 = new MultiThreadingExample();

    @BeforeMethod
    public void setup() {

        MultiThreadingExample multiThreadingExample=new MultiThreadingExample();
        MultiThreadingExample.setBrowsertype("Chrome");
        multiThreadingExample.run();


        MultiThreadingExample.setBrowsertype("Firefox");
        multiThreadingExample.run();

        MultiThreadingExample.setBrowsertype("IE");
        multiThreadingExample.run();

        System.out.println("Starting MyThreads");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Thread has been started");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("In afterMethod Waiting to kill drivers");
        driver.quit();
        driver.quit();
        driver.quit();
        driver.quit();
        driver.quit();
        driver.quit();
        driver.quit();
        driver.quit();

    }


    /**
     * This function checks for Page To Load
     *
     * @param pageURL
     * @return
     */
    public boolean waitForPageToLoad(final String pageURL) {

        WebDriverWait wait = new WebDriverWait(driver, 45);
        return wait.until(new ExpectedCondition<Boolean>() {
                              public Boolean apply(WebDriver d) {

                                  boolean flag = (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
                                  boolean flag1 = driver.getCurrentUrl().contains(pageURL);
                                  return flag && flag1;

                              }
                          }
        );
    }


    /**
     * Utility function to switch to recent Open Window
     */
    public void switchToWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    /**
     * Utility Function to switch between Windows
     *
     * @param windowName
     */
    public void switchToWindow(String windowName) {
        driver.switchTo().window(windowName);

    }

    /**
     * Explicit Wait Utility function to wait for particular element
     *
     * @param element
     */
    public void wait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


  /*  public void BrowserActions(RemoteWebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }*/
//TODO awaitility
    /*public void waitTillElementDisplayed(WebElement element) {
        getawait().until(element::isDisplayed);
    }
*/
	/*public Boolean isElementDisplayed(WebElement element) {p
		return getawait().until(element::isDisplayed, t -> t);
	}

	public Boolean isElementEnabled(WebElement element) {
		return getawait().until(element::isEnabled, t -> t);
	}

	public Boolean isElementinFocus(WebElement element) {
		return getawait().until(() -> element.equals(driver.switchTo().activeElement()), t -> t);
	}*/




}
