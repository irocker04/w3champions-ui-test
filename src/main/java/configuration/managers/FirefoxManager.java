package configuration.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FirefoxManager implements DriverManager {

    private EventFiringWebDriver driver;

    public EventFiringWebDriver createDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new EventFiringWebDriver(new FirefoxDriver());
        }

        return driver;
    }

    @Override
    public void close() {
        driver.close();
    }

}
