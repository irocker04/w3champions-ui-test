package configuration.managers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverManager {

    WebDriver createDriver() throws MalformedURLException;

    void close();
}
