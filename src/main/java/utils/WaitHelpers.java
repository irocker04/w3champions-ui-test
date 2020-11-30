package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitHelpers {

    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    public WaitHelpers(EventFiringWebDriver driver) {
        System.out.println("Wait helper constructor");
        this.driver = driver;
        System.out.println("Assigning driver");
        wait = new WebDriverWait(driver, 10);
        System.out.println("After new WebDriverWait()");
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
