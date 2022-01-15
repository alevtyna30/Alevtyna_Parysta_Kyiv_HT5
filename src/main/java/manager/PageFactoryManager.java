package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public MenuPage getMenuPage(){
        return new MenuPage(driver);
    }

    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage(driver);
    }

    public CategoryPage getCategoryPage(){
        return new CategoryPage(driver);
    }

    public CustomerPreferencesPage getCustomerPreferencesPage(){
        return new CustomerPreferencesPage(driver);
    }

    public GiftCardPage getGiftCardPage(){
        return new GiftCardPage(driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage(){
        return new ShoppingCartPage(driver);
    }

    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }

}
