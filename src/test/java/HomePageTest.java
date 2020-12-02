import models.homePage.TopRank;
import org.testng.annotations.Test;
import pages.GettingStartedPage;
import pages.HomePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    private HomePage homePage;
    private GettingStartedPage gettingStartedPage;

    @Test
    public void shouldDisplay3Links() {
        homePage = new HomePage(driver);
        gettingStartedPage = homePage.clickJoinButton();
        assertThat(gettingStartedPage.getInstructionButtons().size()).isEqualTo(3);
    }

    @Test
    public void shouldDisplay5TopRanks() throws InterruptedException {
        homePage = new HomePage(driver);
        assertThat(homePage.getTopRanks().size()).isEqualTo(5);
        Thread.sleep(5000);
    }

    @Test
    public void shouldDisplayProperTopRankPlayersNames() {
        homePage = new HomePage(driver);
        List<TopRank> actual = homePage.getTopRanks();
        String[] expected = new String[]{"LongDonDing", "ToD", "Cacxa26", "cacxa27", "Happy"};

        assertThat(actual).extracting("name", String.class).contains(expected);
    }
}
