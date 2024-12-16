package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BookingPageSecond {
    private SelenideElement searchField;
    private SelenideElement findButton;
    private SelenideElement openMapButton;
    private SelenideElement firstHotel;
    private SelenideElement dateChooseFirst;
    private SelenideElement dateChooseSecond;
    private SelenideElement dateButton;
    private SelenideElement clickMarker;

    public void openBooking() {
        open("https://www.booking.com/");

        searchField = $x("//*[contains(@id, ':rh:')]").shouldBe(Condition.visible);
        dateButton = $(".e33c97ff6b");
        dateChooseFirst = $("*[data-date='2025-01-13']");
        dateChooseSecond = $("*[data-date='2025-01-18']");
        findButton = $("button[type='submit']");
        openMapButton = $(".c6da63b617");
        firstHotel = $("[data-testid='property-list-map-card']");
        clickMarker = $("svg[data-testid='marker-icon-dot'] circle");

    }

    public void searchForCity(String city) {
        searchField.setValue(city);
        sleep(5000);
    }

    public void datesChoosing() {
        dateButton.click();
        sleep(5000);
        dateChooseFirst.click();
        sleep(5000);
        dateChooseSecond.click();
        sleep(5000);
    }

    public void clickFind() {
        findButton.click();
        sleep(10000);
    }

    public void openMap() {
        openMapButton.click();
        sleep(10000);
    }

    public void hoverOverHotelCard() {
        firstHotel.hover();
        sleep(10000);
    }

    public void clickOnMarker() {
        clickMarker.click();
        sleep(20000);
    }
}
