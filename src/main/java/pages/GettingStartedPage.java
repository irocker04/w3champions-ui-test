package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GettingStartedPage extends BasePage {

    @FindBy(css = "button.join-button")
    private List<WebElement> instructionButtons;

    public GettingStartedPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getInstructionButtons() {
        return instructionButtons;
    }
}
