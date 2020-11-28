import configuration.Driver;
import configuration.DriverFactory;
import configuration.DriverModule;
import configuration.listeners.DriverEventListener;
import configuration.listeners.TestListener;
import configuration.managers.DriverManager;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
@Guice(modules = {
        DriverModule.class
})
public class BaseTest {

    protected EventFiringWebDriver driver;
    private DriverManager driverManager;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverFactory.get(Driver.CHROME);
        driver = driverManager.createDriver();
        DriverEventListener driverEventListener = new DriverEventListener();
        driver.register(driverEventListener);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
