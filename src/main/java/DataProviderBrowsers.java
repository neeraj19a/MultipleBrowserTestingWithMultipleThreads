import org.testng.annotations.DataProvider;

public class DataProviderBrowsers {

    @DataProvider(name = "browser")
    public Object[][] returnBrowser() {
        Object[][] objects = {{"Firefox"}, {"Chrome"}, {"IE"}};
        return objects;
    }
}
