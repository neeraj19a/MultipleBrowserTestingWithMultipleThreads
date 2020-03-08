
import java.io.File;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

public class MultiThreadingExample extends Thread {

    protected static WebDriver driver;
    private static String browsertype;

    public String getBrowsertype() {
        return browsertype;
    }

    public static void setBrowsertype(String browsertype) {

        MultiThreadingExample.browsertype = browsertype;
    }


   /* @Override
    public void run() {

        System.out.println("Thread- Started" + Thread.currentThread().getName());

        String threadname = Thread.currentThread().getName();
        System.out.println("threadname-->" + threadname);

        try {
            Thread.sleep(1000);
            System.out.println("Triggering Browser Setup" + getBrowsertype());

            setUp(getBrowsertype());
            Thread.sleep(1000);
            //testGoogleSearch();

            SecondTest secondTest = new SecondTest();
            secondTest.GOOGLE4();
            secondTest.YANDEX();
            secondTest.Facebook();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // tearDown();
        }
        System.out.println("Thread- END " + Thread.currentThread().getName());
    }*/

    @Override
    public void run() {

        Method[] methods = SecondTest.class.getDeclaredMethods();// Using Reflection to get all Test Functions
        final SecondTest m = new SecondTest();
        //ArrayList<Thread> threadList = new ArrayList<Thread>();
        ArrayList<String> browsers = new ArrayList<String>();
        browsers.add("Chrome");
        browsers.add("IE");
        browsers.add("Firefox");


        for (int i = 0; i < browsers.size(); i++) {
            setBrowsertype(browsers.get(i));
            System.out.println("Triggering Browser Setup" + getBrowsertype());

            try {
                setUp(getBrowsertype());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Runnable run = null;
            for (int j = 0; j < methods.length; j++) {
                final String name = methods[j].getName(); // Getting all methods name i.e. okTest, OkTest1
                if (!name.equalsIgnoreCase("myMain1") && !name.equalsIgnoreCase("run")) { // we dont want to run Main Function and 'run'
// We want to run only okTest and okTest1 funtions like that

                    run = new Runnable() {
                        public void run() {

                            try {
                                Method method = m.getClass().getMethod(name);
                                method.invoke(m); // Invoking the method using Reflection
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    Thread thread1 = new Thread(run);// invoking Thread to call run method Overrided above
                    Thread thread2 = new Thread(run);// invoking Thread to call run method Overrided above
                    Thread thread3 = new Thread(run);// invoking Thread to call run method Overrided above

                    thread1.start();// Starting thread to execute above methods
                    thread2.start();// Starting thread to execute above methods
                    thread3.start();// Starting thread to execute above methods

                }

            }
        }
    }

    public void myMain1() {
        this.run();
    }

    // set up the method to initialize driver object
    public void setUp(String browsertype) throws Exception {
        if (getBrowsertype().contains("IE")) {
            System.out.println("Setting Driver for IE");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            System.setProperty("webdriver.ie.driver", "C:\\Users\\T460\\Downloads\\Drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver(capabilities);

        } else if (getBrowsertype().contains("Firefox")) {
            System.out.println("Setting Driver for Firefox");

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\T460\\Downloads\\Drivers\\geckodriver.exe");

            driver = new FirefoxDriver();
        } else if (getBrowsertype().contains("Chrome")) {
            System.out.println("Setting Driver for Chrome");

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\T460\\Downloads\\Drivers\\chromedriver.exe");

            driver = new ChromeDriver();
            System.out.println("Created Chrome ");
        }

       /* Url = "https://www.google.co.in/";

        driver.get(Url);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
*/
    }

    /*// test scripts

    public void testGoogleSearch() throws Exception {

        String actualtitle = driver.getTitle();

        String expectedTitle = "Google";

        Assert.assertEquals(actualtitle, expectedTitle, "The expected title matched");

        System.out.println("Cross Browser Testing Example");

        System.out.println("################Actual:" + actualtitle + "Expected:" + expectedTitle + "#################");
    }*/

    /*
    // tear down function to close browser
    public void tearDown() {

        driver.close();
        driver.quit();

    }
*/
       /*// main method to create the thread and run multiple threads
    public static void main(String[] args) {
        Thread t1 = new MultiThreadingExample("Thread Chrome", "Chrome");
        Thread t2 = new MultiThreadingExample("Thread IE", "IE");
        Thread t3 = new MultiThreadingExample("Thread Firefox", "Firefox");
        System.out.println("Starting MyThreads");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Thread has been started");
    }
*/
}