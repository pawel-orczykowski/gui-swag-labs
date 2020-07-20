package gui_tests.page_objects;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

public class YourInformationPage {
    private SelenideElement firstName = $("#first-name");
    private SelenideElement lastName = $("#last-name");
    private SelenideElement zipCode = $("#postal-code");
    private SelenideElement continueButton = $(".cart_button");

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        this.continueButton.click();
    }
}
