package configuration.managers;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface DriverManager {

    EventFiringWebDriver createDriver();
    void close();
}
