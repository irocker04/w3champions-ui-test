package configuration.managers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ChromeManager implements DriverManager {

    private EventFiringWebDriver driver;

    public EventFiringWebDriver createDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
//            options.addArguments("disable-gpu");
//            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver(options));
        }

        System.out.println("Created ChromeDriver");
        return driver;
    }

    @Override
    public void close() {
        driver.close();
    }
}
