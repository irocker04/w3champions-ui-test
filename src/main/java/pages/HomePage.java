package pages;

import models.homePage.TopRank;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "button.join-button")
    private WebElement joinButton;

    @FindBy(css = "footer a")
    private WebElement imprintButton;

    @FindBy(css = "table.custom-table tr td div.row")
    private List<WebElement> topRanks;

    public HomePage(EventFiringWebDriver driver) {
        super(driver);
        driver.get("https://www.w3champions.com/");
    }

    public GettingStartedPage clickJoinButton() {
        super.clickButton(joinButton);
        return new GettingStartedPage(driver);
    }

    public ImprintPage clickImprintButton() {
        super.clickButton(imprintButton);
        return new ImprintPage(driver);
    }

    public List<TopRank> getTopRanks() {
        waitHelpers.waitForVisibilityOfAllElements(topRanks);
        List<TopRank> topRanks = new ArrayList<>();
        for (WebElement row : this.topRanks) {
            int position = Integer.parseInt(getTextFromElement(row, "div:first-child span").replace(".", ""));

            String rawName = getTextFromElement(row, "div:nth-child(2)");
            int breakLinePosition = rawName.indexOf("\n");
            String name = rawName.substring(0, breakLinePosition);

            int colonIndex = rawName.indexOf(":");
            String[] gamesNumbers = rawName.substring(colonIndex + 2).split("/");
            int win = Integer.parseInt(gamesNumbers[0]);
            int loss = Integer.parseInt(gamesNumbers[1]);
            int total = Integer.parseInt(gamesNumbers[2]);
            assert win + loss == total;

            TopRank topRank = new TopRank(position, name, win, loss, total);
            topRanks.add(topRank);
        }
        return topRanks;
    }
}
