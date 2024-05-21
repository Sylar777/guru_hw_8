package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {
    public final SelenideElement result = $(".action-inp");

    public SelenideElement getButton(String value) {
        return $("button[value='" + value + "']");
    }
}
