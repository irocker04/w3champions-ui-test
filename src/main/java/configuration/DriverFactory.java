package configuration;

import configuration.managers.ChromeManager;
import configuration.managers.DriverManager;
import configuration.managers.FirefoxManager;

public class DriverFactory {

    private static DriverManager driverManager;

    public static DriverManager get(Driver driverType) {
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxManager();
                break;
        }

        return driverManager;
    }
}
