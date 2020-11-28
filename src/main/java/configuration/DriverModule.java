package configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import configuration.managers.ChromeManager;
import configuration.managers.DriverManager;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverModule extends AbstractModule {

    @Override
    public void configure() {
        bind(DriverManager.class)
                .to(ChromeManager.class)
                .in(Scopes.SINGLETON);
    }

    @Provides
    public EventFiringWebDriver getDriver(DriverManager driverManager) {
        return driverManager.createDriver();
    }

//    @Provides
//    public WaitHelpers getWaitHelper(EventFiringWebDriver driver) {
//        return new WaitHelpers(driver);
//    }
}
