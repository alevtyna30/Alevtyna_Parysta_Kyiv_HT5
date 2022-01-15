package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//a[@aria-label='Toys & Games']")
    private WebElement toysAndGamesButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInPage;

    @FindBy(xpath = "//a[@href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")
    private WebElement giftCardsButton;

    @FindBy(xpath = "//input[@data-action-type='DISMISS']")
    private List<WebElement> acceptPopUps;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@id='icp-nav-flyout']")
    private WebElement changeLanguageButton;

    @FindBy(xpath = "//a[@class='a-carousel-goto-nextpage']")
    private WebElement carouselRow;

    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    private WebElement curtButton;

    @FindBy(xpath = "//a[@id='nav-global-location-popover-link']")
    private WebElement globalLocationButton;

    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_customerservice']")
    private WebElement customerService;

    @FindBy(xpath = "//a[@data-csa-c-id='tas5uh-vvrdqk-81dixc-ou8a05']")
    private WebElement todaysDeals;

    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement logo;

    @FindBy(xpath = "//span[contains(@class,'nav-cart-1')]")
    private WebElement cartContainer;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnCatalogButton() {
        productCatalogButton.click();
    }

    public void clickOnToysAndGamesButton(){
        toysAndGamesButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return cartContainer.getText();
    }

    public void clickOnSignInPage(){
        signInPage.click();
    }

    public void clickOnPopUpDeliveryAddress(){
        acceptPopUps.forEach(WebElement::click);
    }

    public void clickOnGiftCardButton(){
        giftCardsButton.click();
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnChangeLanguageButton(){
        changeLanguageButton.click();
    }

    public boolean isCarouselRowVisible(){
        return carouselRow.isDisplayed();
    }
    public boolean isCartButtonVisible(){
        return curtButton.isDisplayed();
    }

    public boolean isGlobalLocationButtonVisible(){
        return globalLocationButton.isDisplayed();
    }

    public boolean isCustomerServiceVisible(){
        return customerService.isDisplayed();
    }

    public boolean isTodaysDealsVisible(){
        return todaysDeals.isDisplayed();
    }

    public boolean isLogoVisible(){
        return logo.isDisplayed();
    }

    public boolean isSearchFieldVisible(){
        return searchInput.isDisplayed();
    }

    public boolean isSignInButtonVisible(){
        return signInPage.isDisplayed();
    }

    public boolean isCatalogButtonVisible(){
        return productCatalogButton.isDisplayed();
    }

    public boolean isGiftCardsButtonVisible(){
        return giftCardsButton.isDisplayed();
    }

    public WebElement getCartContainer(){
        return cartContainer;
    }

}