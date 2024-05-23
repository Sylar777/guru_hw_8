package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.CalculatorPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public final CalculatorPage calculatorPage = new CalculatorPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://oleksandrchernokolov.github.io";
    }

    @BeforeEach
    public void setUp() {
        open("/Calculator");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
