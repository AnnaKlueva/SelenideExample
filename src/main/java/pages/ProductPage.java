package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

    @FindBy(className = "product__title")
    private SelenideElement productTitle;

    @Step
    public SelenideElement getProduct(){
        return productTitle;
    }

}
