package pages;

import static com.codeborne.selenide.Selenide.$;

public class HotelDetailsEqual {

    private String hotelName2;
    private String starRating2;
    private String averageRating2;
    private String reviewCount2;
    private String price2;

    public void extractHotelDetails2() {

        hotelName2 = $("h2.d2fee87262.pp-header__title").getText();
        starRating2 = $("span[data-testid='rating-stars']").getText();
        averageRating2 = $("div.a3b8729ab1.d86cee9b25").getText();
        reviewCount2 = $("div.abf093bdfe.f45d8e4c32.d935416c47").getText();
        price2 = $("div.bui-price-display__value.prco-text-nowrap-helper.prco-inline-block-maker-helper.prco-f-font-heading").getText();

    }

    public String getHotelName2() {
        return hotelName2;
    }

    public String getStarRating2() {
        return starRating2;
    }

    public String getAverageRating2() {
        return averageRating2;
    }

    public String getReviewCount2() {
        return reviewCount2;
    }

    public String getPrice2() {
        return price2;
    }
}
