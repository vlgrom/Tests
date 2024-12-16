package pages;

public class HotelComparator {

    public void compareHotels(HotelDetails hotel1, HotelDetailsEqual hotel2) {
        boolean namesEqual = hotel1.getHotelName().equals(hotel2.getHotelName2());
        boolean starRatingsEqual = hotel1.getStarRating().equals(hotel2.getStarRating2());
        boolean averageRatingsEqual = hotel1.getAverageRating().equals(hotel2.getAverageRating2());
        boolean reviewCountsEqual = hotel1.getReviewCount().equals(hotel2.getReviewCount2());
        boolean pricesEqual = hotel1.getPrice().equals(hotel2.getPrice2());

        System.out.println("Названия отелей равны: " + namesEqual);
        System.out.println("Рейтинги звезд равны: " + starRatingsEqual);
        System.out.println("Средние рейтинги равны: " + averageRatingsEqual);
        System.out.println("Количество отзывов равно: " + reviewCountsEqual);
        System.out.println("Цены равны: " + pricesEqual);
    }
}
