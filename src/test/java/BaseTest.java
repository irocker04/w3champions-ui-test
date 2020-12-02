import configuration.Driver;
import configuration.DriverFactory;
import configuration.listeners.TestListener;
import configuration.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driverManager = DriverFactory.get(Driver.CHROME);
        driver = driverManager.createDriver();
//        DriverEventListener driverEventListener = new DriverEventListener();
//        driver.register(driverEventListener);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
