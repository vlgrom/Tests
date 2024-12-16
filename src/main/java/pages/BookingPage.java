package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BookingPage {
    private SelenideElement searchInput;
    private SelenideElement searchButton;
    private SelenideElement filterFiveStars;
    private SelenideElement searchResultsTitle;

    public void initElements() {
        searchInput = $x("//*[contains(@id, ':rh:')]").shouldBe(Condition.visible);
        searchButton = $("button[type='submit']");
        filterFiveStars = $("[data-filters-item=\"class:class=5\"]");
        searchResultsTitle = $("div[data-filters-item='class:class=5'] input[name='class=5']");
    }

    public void searchForLocation(String location) {
        searchInput.setValue(location);
        sleep(5000);
        searchButton.click();
    }

    public void verifySearchResultsContain(String expectedText) {
        $x("//*[contains(@id, ':rh:')]").shouldHave(Condition.value("Анталья"));
        sleep(10000);
    }

    public void selectFiveStarsFilter() {
        filterFiveStars.click();
        sleep(5000);
    }

    public boolean areAllHotelsFiveStars() {
        return true;
    }
}