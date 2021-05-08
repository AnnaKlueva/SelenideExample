package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class CategoryPage {
    @FindBy(xpath = "//a[contains(@href,\"168814171\")]")
    private SelenideElement galaxyBlackPhone;

    @FindBy(css = "[name=\"search\"]")
    private SelenideElement searchImLookingFor;

    @FindBy(className = "search-form__submit")
    private SelenideElement findButton;

    @FindBy(className = "goods-tile__title")
    private ElementsCollection products;

    @Step
    public ProductPage clickOnMobilePhone(){
        galaxyBlackPhone.click();
        return page(ProductPage.class);
    }

    @Step
    public ElementsCollection findProducts(String searchWord){
        searchImLookingFor.setValue(searchWord);
        findButton.click();
        return products;
    }
}
