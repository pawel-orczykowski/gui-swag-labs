package gui_tests.page_objects;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class OverviewPage {
    private SelenideElement finishButton = $x("//*[contains(text(), 'FINISH')]");

    public void clickFinishButton() {
        this.finishButton.click();
    }
}
