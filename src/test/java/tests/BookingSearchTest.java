package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.BookingPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(AllureJunit5.class)
class BookingSearchTest {

    @Test
    @Description("Тест поиска отелей в Анталье и применения фильтров")
    public void testBookingFiveStarsInAntalya() {
        BookingPage bookingPage = new BookingPage();

        // Открытие сайта Booking.com
        open("https://booking.com/");

        // Инициализация элементов страницы после открытия сайта
        bookingPage.initElements();

        // Поиск города
        bookingPage.searchForLocation("Анталья");

        // Проверка результата поиска
        bookingPage.verifySearchResultsContain("Анталья");

        // Применение фильтра "5 звёзд"
        bookingPage.selectFiveStarsFilter();

        // Проверка на предмет того, что все отели имеют 5 звёзд
        assertTrue(bookingPage.areAllHotelsFiveStars(), "Не все отели имеют 5 звёзд!");
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
