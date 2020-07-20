package gui_tests.page_objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private SelenideElement loginInput = $("#user-name");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement submitButton = $("#login-button");
    private SelenideElement errorButton = $(".error-button");

    public void setLogin(String login) {
        this.loginInput.sendKeys(login);
    }

    public void setPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        this.submitButton.click();
    }

    public SelenideElement getErrorButton() {
        return this.errorButton;
    }
}
