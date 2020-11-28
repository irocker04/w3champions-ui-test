package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.WaitHelpers;

public class BasePage {

    protected EventFiringWebDriver driver;
    protected WaitHelpers waitHelpers;

    public BasePage(EventFiringWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelpers = new WaitHelpers(driver);
    }

    public void clickButton(WebElement element) {
        waitHelpers.waitForVisibilityOfElement(element);
        element.click();
    }

    public String getTextFromElement(WebElement parentElement, String css) {
        waitHelpers.waitForVisibilityOfElement(parentElement);
        return parentElement.findElement(By.cssSelector(css)).getText().trim();
    }
}
