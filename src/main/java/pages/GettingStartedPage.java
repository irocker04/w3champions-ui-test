package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class GettingStartedPage extends BasePage {

    @FindBy(css = "button.join-button")
    private List<WebElement> instructionButtons;

    public GettingStartedPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public List<WebElement> getInstructionButtons() {
        return instructionButtons;
    }
}
