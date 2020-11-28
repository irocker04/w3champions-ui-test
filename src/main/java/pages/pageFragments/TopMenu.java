package pages.pageFragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TopMenu {

    @FindBy(linkText = "Tournaments")
    private WebElement tournamentsButton;

    public TopMenu(EventFiringWebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTournamentsButton() {
        tournamentsButton.click();
    }
}
