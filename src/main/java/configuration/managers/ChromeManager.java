package configuration.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ChromeManager implements DriverManager {

    private EventFiringWebDriver driver;

    public EventFiringWebDriver createDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new EventFiringWebDriver(new ChromeDriver());
        }

        return driver;
    }

    @Override
    public void close() {
        driver.close();
    }
}
