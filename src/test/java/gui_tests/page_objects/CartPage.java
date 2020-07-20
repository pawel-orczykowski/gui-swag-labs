package gui_tests.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private Map<String, SelenideElement> productSpecification = new HashMap<>();

    private ElementsCollection productsCollection = $$(".cart_item");
    private SelenideElement productQuantity = $(".cart_quantity");
    private SelenideElement productName = $(".inventory_item_name");
    private SelenideElement productDescription = $(".inventory_item_desc");
    private SelenideElement productPrice = $(".inventory_item_price");
    private SelenideElement checkoutButton = $(".checkout_button");


    public void pickFirstProductValues() {
        SelenideElement first = this.productsCollection.first();
        setProductData(first);
    }

    private void setProductData(SelenideElement element) {
        SelenideElement product = element;

        productSpecification.put("name", $(product.find(productName.getSearchCriteria())));
        productSpecification.put("qty", $(product.find(productQuantity.getSearchCriteria())));
        productSpecification.put("desc", $(product.find(productDescription.getSearchCriteria())));
        productSpecification.put("price", $(product.find(productPrice.getSearchCriteria())));
    }

    public SelenideElement getProduectName(){
        return productSpecification.get("name");
    }

    public SelenideElement getQty(){
        return productSpecification.get("qty");
    }

    public SelenideElement getProduectDesc(){
        return productSpecification.get("desc");
    }

    public SelenideElement getProduectPrice(){
        return productSpecification.get("price");
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}
