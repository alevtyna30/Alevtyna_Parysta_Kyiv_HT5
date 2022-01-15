package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
    private WebElement closePopUp;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart(){
        addToCart.click();
    }

    public WebElement getClosePopUp(){
        return closePopUp;
    }

    public void clickOnClosePopUp(){
        closePopUp.click();
    }

    public WebElement getAddToCart(){
        return addToCart;
    }

}
