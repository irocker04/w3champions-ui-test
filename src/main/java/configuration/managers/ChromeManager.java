package configuration.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeManager implements DriverManager {

    private WebDriver driver;

    public WebDriver createDriver() throws MalformedURLException {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox");
//            options.addArguments("--headless");
//            options.addArguments("disable-gpu");
            WebDriverManager.chromedriver().setup();
            driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), options);

        }

        System.out.println("Created ChromeDriver");
        return driver;
    }

    @Override
    public void close() {
        driver.close();
    }
}
