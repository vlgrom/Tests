package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import pages.BookingPageSecond;
import pages.HotelComparator;
import pages.HotelDetails;
import pages.HotelDetailsEqual;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class BookingTestSecond {
    private final BookingPageSecond bookingPage = new BookingPageSecond();
    private final HotelDetails hotelDetails = new HotelDetails();
    private final HotelDetailsEqual hotelDetailsEqual = new HotelDetailsEqual();
    private final HotelComparator comparator = new HotelComparator();

    @Test
    @Description("Автоматизация поиска отелей на сайте Booking")
    public void testBooking() {
        bookingPage.openBooking();

        // Вводим город
        bookingPage.searchForCity("Лондон");

        // Выбираем даты
        bookingPage.datesChoosing();

        // Нажимаем на кнопку "Найти"
        bookingPage.clickFind();

        // Открываем карту
        bookingPage.openMap();

        // Наводим на карточку слева
        bookingPage.hoverOverHotelCard();

        // Извлекаем данные из HotelDetails и выводим в консоль
        hotelDetails.extractHotelDetails();
        String hotelName = hotelDetails.getHotelName(); // Получаем название отеля
        System.out.println("Название отеля: " + hotelName);
        String starRating = hotelDetails.getStarRating(); // Получаем кол-во звезд отеля
        System.out.println("Звезды: " + starRating);
        String averageRating = hotelDetails.getAverageRating(); // Получаем рейтинг отеля
        System.out.println("Рейтинг: " + averageRating);
        String reviewCount = hotelDetails.getReviewCount(); // Получаем кол-во отзывов отеля
        System.out.println("Отзывы: " + reviewCount);
        String price = hotelDetails.getPrice(); // Получаем цену суток отеля
        System.out.println("Цена: " + price);

        // Тыкаем на маркер на карте
        bookingPage.clickOnMarker();

        // Извлекаем данные из HotelDetailsEqual (это у нас отель в "открывшейся" странице)
        hotelDetailsEqual.extractHotelDetails2();

        // Проводим сравнение данных отелей
        comparator.compareHotels(hotelDetails, hotelDetailsEqual);
    }

    @AfterAll
    static void generateAndOpenReport() {
        generateAllureReport();
        openAllureReport();
    }

    private static void generateAllureReport() {

        String allurePath = "C:\\Users\\user\\Desktop\\allure-2.32.0\\bin\\allure.bat";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(allurePath, "serve", "allure-results");
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor(10, TimeUnit.SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void openAllureReport() {

        String allurePath = "C:\\Users\\user\\Desktop\\allure-2.32.0\\bin\\allure.bat";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(allurePath, "open", "allure-results");
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor(10, TimeUnit.SECONDS);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
