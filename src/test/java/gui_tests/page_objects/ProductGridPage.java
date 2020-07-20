package gui_tests.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ProductGridPage {
    private Map<String, String> productSpecification = new HashMap<>();
    private Map<String, SelenideElement> productSpecButton = new HashMap<>();

    private SelenideElement productPageHeader = $(".product_label");
    private ElementsCollection productsCollection = $$(".inventory_item");
    private SelenideElement productName = $(".inventory_item_name");
    private SelenideElement productDescription = $(".inventory_item_desc");
    private SelenideElement productPrice = $(".inventory_item_price");
    private SelenideElement addProductButton = $(".btn_primary");
    private SelenideElement shoppingCartButton = $("[data-icon='shopping-cart']");

    public SelenideElement getProductPageHeader() {
        return this.productPageHeader;
    }

    public void pickRandomProduct() {
        SelenideElement randomProduct = this.productsCollection.get(new Random().nextInt(this.productsCollection.size()));
        setProductData(randomProduct);
        addProductToCart();
    }

    public void pickFirstProduct() {
        SelenideElement first = this.productsCollection.first();
        setProductData(first);
        addProductToCart();
    }

    private void setProductData(SelenideElement element) {
        SelenideElement product = element;

        productSpecification.put("name", product.find(productName.getSearchCriteria()).getText());
        productSpecification.put("desc", product.find(productDescription.getSearchCriteria()).getText());
        productSpecification.put("price", product.find(productPrice.getSearchCriteria()).getText());
        productSpecButton.put("button", product.find(addProductButton.getSearchCriteria()));
    }

    private void addProductToCart(){
        this.productSpecButton.get("button").click();
    }

    public String getProduectName(){
        return productSpecification.get("name");
    }

    public String getProduectDesc(){
        return productSpecification.get("desc");
    }

    public String getProduectPrice(){
        return productSpecification.get("price");
    }

    public void clickShopCartIcon(){
        this.shoppingCartButton.click();
    }

}
