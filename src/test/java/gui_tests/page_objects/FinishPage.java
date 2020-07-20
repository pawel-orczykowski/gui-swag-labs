package gui_tests.page_objects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class FinishPage {
    private SelenideElement finishPageHeader = $(".subheader");
    private SelenideElement thankYouMessage = $(".complete-header");
    private SelenideElement nextStepsMessage = $(".complete-text");
    private SelenideElement ponyExpressPicture = $(".pony_express");

    public SelenideElement getFinishPageHeader() {
        return finishPageHeader;
    }

    public SelenideElement getThankYouMessage() {
        return thankYouMessage;
    }

    public SelenideElement getNextStepsMessage() {
        return nextStepsMessage;
    }

    public SelenideElement getPonyExpressPicture() {
        return ponyExpressPicture;
    }
}
