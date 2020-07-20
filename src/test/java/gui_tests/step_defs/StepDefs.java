package gui_tests.step_defs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import gui_tests.page_objects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
    private LoginPage loginPage = new LoginPage();
    private ProductGridPage productGridPage = new ProductGridPage();
    private CartPage cartPage = new CartPage();
    private YourInformationPage yourInformationPage = new YourInformationPage();
    private OverviewPage overviewPage = new OverviewPage();
    private FinishPage finishPage = new FinishPage();

    @Given("shop main page")
    public void shop_main_page() {
        Selenide.open(Configuration.baseUrl);
    }

    @When("user enters {string} as login")
    public void user_enters_login(String login) {
        loginPage.setLogin(login);
    }

    @When("user enters {string} as password")
    public void user_enters_password(String password) {
        loginPage.setPassword(password);
    }

    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        loginPage.clickSubmit();
    }

    @Then("user is logged in to shop")
    public void user_is_logged_in_to_shop() {
        productGridPage.getProductPageHeader().should(Condition.exactTextCaseSensitive("Products"));
    }

    @Then("user is not logged in to shop")
    public void user_is_not_logged_in_to_shop() {
        loginPage.getErrorButton().should(Condition.appear);
    }

    @When("user adds random product to cart from Product page")
    public void user_adds_random_product_to_cart_from_product_page() {
        productGridPage.pickRandomProduct();
    }

    @When("user clicks on cart icon from top menu")
    public void user_clicks_on_cart_icon_from_top_menu() {
        productGridPage.clickShopCartIcon();
    }

    @Then("picked product is present in cart")
    public void picked_product_is_present_in_cart() {
        cartPage.pickFirstProductValues();
        cartPage.getProduectName().shouldBe(Condition.exactText(productGridPage.getProduectName()));
        cartPage.getQty().shouldBe(Condition.exactText("1"));
        cartPage.getProduectDesc().shouldBe(Condition.exactText(productGridPage.getProduectDesc()));
        cartPage.getProduectPrice().shouldBe(Condition.matchesText(productGridPage.getProduectPrice().substring(1)));

    }

    @When("user clicks on checkout button in Your Cart page")
    public void user_clicks_on_checkout_button_in_your_cart_page() {
        cartPage.clickCheckoutButton();
    }

    @When("user enters {string} as First Name in Checkout: Your information page")
    public void user_enters_as_first_name_in_checkout_your_information_page(String firstName) {
        yourInformationPage.setFirstName(firstName);
    }

    @When("user enters {string} as Last Name in Checkout: Your information page")
    public void user_enters_as_last_name_in_checkout_your_information_page(String lastName) {
        yourInformationPage.setLastName(lastName);
    }

    @When("user enters {string} as Zip Code in Checkout: Your information page")
    public void user_enters_as_zip_postal_code_in_checkout_your_information_page(String zipCode) {
        yourInformationPage.setZipCode(zipCode);
    }

    @When("user clicks on continue button in Checkout: Your information page")
    public void user_clicks_on_continue_button_in_checkout_your_information_page() {
        yourInformationPage.clickContinueButton();
    }

    @When("user clicks on finish button in Checkout: Overview page")
    public void user_clicks_on_finish_button_in_checkout_overview_page() {
        overviewPage.clickFinishButton();
    }

    @Then("user is seeing Finish page")
    public void user_sess_finish_page() {
        finishPage.getFinishPageHeader().shouldBe(Condition.exactText("Finish"));
    }

    @Then("Thank You massage {string} is displayed")
    public void thank_you_massage_is_displayed(String message) {
        finishPage.getThankYouMessage().shouldBe(Condition.exactText(message));
    }

    @Then("Order next steps message: {string} is displayed")
    public void order_next_steps_message_is_displayed(String message) {
        finishPage.getNextStepsMessage().shouldBe(Condition.exactText(message));
    }

    @Then("Pony Express graphic is displayed")
    public void pony_express_graphic_is_displayed() {
        finishPage.getPonyExpressPicture().shouldBe(Condition.attribute("src", "https://www.saucedemo.com/img/pony-express.png"));
    }

}
