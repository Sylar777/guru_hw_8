package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.attribute;

public class CalculatorTest extends BaseTest {
    @ParameterizedTest(name = "Check Chernokov Calculator with Value Source = {0}")
    @ValueSource(strings = {"5", "8", "0"})
    void checkChernokovCalculatorWithValueSource(String value) {
        calculatorPage.getButton(value).click();
        calculatorPage.getButton("+").click();
        calculatorPage.getButton(value).click();
        calculatorPage.getButton("=").click();
        var result = String.valueOf((Integer.parseInt(value) * 2));
        calculatorPage.result.shouldHave(attribute("data-value", result));
    }

    @ParameterizedTest(name = "Check Chernokov Calculator with CSV Source: {0} + {1} = {2}")
    @CsvSource(value = {
            "5,6,11",
            "3,9,12",
            "0,2,2"
    })
    void checkChernokovCalculatorWithScvSource(String arg1, String arg2, String result) {
        calculatorPage.getButton(arg1).click();
        calculatorPage.getButton("+").click();
        calculatorPage.getButton(arg2).click();
        calculatorPage.getButton("=").click();
        calculatorPage.result.shouldHave(attribute("data-value", result));
    }

    @ParameterizedTest(name = "Check Chernokov Calculator with Method Source: {0} + {1} = {2}")
    @MethodSource
    void checkChernokovCalculatorWithMethodSource(String arg1, String arg2, String result) {
        calculatorPage.getButton(arg1).click();
        calculatorPage.getButton("+").click();
        calculatorPage.getButton(arg2).click();
        calculatorPage.getButton("=").click();
        calculatorPage.result.shouldHave(attribute("data-value", result));
    }

    static Stream<Arguments> checkChernokovCalculatorWithMethodSource() {
        return Stream.of(
                Arguments.of("1", "6", "7"),
                Arguments.of("3", "7", "10"),
                Arguments.of("0", "0", "0"));
    }
}
