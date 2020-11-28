package configuration.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ChromeManager implements DriverManager {

    private EventFiringWebDriver driver;

    public EventFiringWebDriver createDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
            WebDriverManager.chromedriver().setup();
            driver = new EventFiringWebDriver(new ChromeDriver(options));
        }

        return driver;
    }

    @Override
    public void close() {
        driver.close();
    }
}
