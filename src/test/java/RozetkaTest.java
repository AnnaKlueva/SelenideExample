import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class RozetkaTest extends SelenideRunner {

    @Test
    public void userCanLogin() {
        open("http://example.com/login");
        $(byName("user.name")).setValue("johny");
        $("#submit").click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $("#username").shouldHave(text("Hello, Johny!")); // Waits until element's text is displayed
    }

    @Feature("Rosetka: find products")
    @Test
    public void verifySearchFieldImLookingFunctionality() {
    /*    String searchWord = "Galaxy";
        CategoryPage categoryPage = new CategoryPage();
        List<WebElement> searchResults = categoryPage.findProducts(searchWord);

        for (WebElement item: searchResults){
            Assertions.assertTrue(item.getText().contains(searchWord),"Current search result NOT contain 'Galaxy' in it's name");
        }*/
        String searchWord = "Galaxy";
        CategoryPage categoryPage = open(Constants.BASIC_CATEGORY_URL, CategoryPage.class);
        ElementsCollection searchResults = categoryPage.findProducts(searchWord);

        for(SelenideElement item: searchResults){
            item.shouldHave(text(searchWord));
        }
    }

    @Test
    public void verifyNavigationToProductDetails() {
/*        CategoryPage categoryPage = new CategoryPage();
        ProductPage productPage = categoryPage.clickOnMobilePhone();
        Assertions.assertTrue(productPage.getProductTitle().contains("Galaxy"));*/

        CategoryPage categoryPage = open(Constants.BASIC_CATEGORY_URL, CategoryPage.class);
        ProductPage productPage = categoryPage.clickOnMobilePhone();


        productPage.getProduct().shouldHave(text("Galaxy"));
    }
}
