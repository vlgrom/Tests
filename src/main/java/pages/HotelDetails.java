package pages;

import static com.codeborne.selenide.Selenide.$;

public class HotelDetails {

    private String hotelName;
    private String starRating;
    private String averageRating;
    private String reviewCount;
    private String price;

    public void extractHotelDetails() {

        hotelName = $("h2[data-testid='header-title']").getText();
        starRating = $("[data-testid='rating-stars']").attr("aria-label");
        averageRating = $(".a3b8729ab1.d86cee9b25").getText().replace("Оценка 7,8", "").trim();
        reviewCount = $(".abf093bdfe.f45d8e4c32.d935416c47").getText();
        price = $("span[data-testid='price-and-discounted-price']").getText();
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getStarRating() {
        return starRating;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public String getPrice() {
        return price;
    }
}