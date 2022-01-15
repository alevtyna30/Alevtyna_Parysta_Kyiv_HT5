package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    MenuPage menuPage;
    CategoryPage categoryPage;
    SearchResultPage searchResultPage;
    ShoppingCartPage shoppingCartPage;
    SignInPage signInPage;
    GiftCardPage giftCardPage;
    CustomerPreferencesPage customerPreferencesPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("user clicks catalog button")
    public void UserClicksCatalogButton() {
        homePage.clickOnCatalogButton();
    }

    @And("user clicks category of product")
    public void UserClicksCategoryOfProduct() {
        menuPage = pageFactoryManager.getMenuPage();
        menuPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, menuPage.getClickOnComputersButton());
        menuPage.clickOnComputersButton();
    }

    @And("user clicks on subcategory")
    public void UserClicksOnSubcategory() {
        menuPage.clickOnMonitorsButton();
    }

    @And("user applies filter")
    public void UserAppliesFilter() {
        menuPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, menuPage.getChooseBrandOnTheFilter());
        menuPage.applyTheFilter();
    }

    @Then("user checks that current page contains {string}")
    public void UserChecksThatCurrentPageContainsBrandName(final String brandName) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        for (WebElement webElement : searchResultPage.getSearchResultsList()) {
            assertTrue(webElement.getText().contains(brandName));
        }
    }

    @And("User clicks 'toys and games' button")
    public void userClicksToysAndGamesButton() {
        homePage.clickOnToysAndGamesButton();
    }

    @And("User choose the product")
    public void userChooseTheProduct() {
        categoryPage = pageFactoryManager.getCategoryPage();
        categoryPage.clickOnProductButton();
    }

    @And("User clicks 'Add to Cart' button on product")
    public void userClicksAddToCartButtonOnProduct() {
        categoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(40, shoppingCartPage.getAddToCart());
        shoppingCartPage.clickAddToCart();
    }

    @And("User clicks 'close' popup")
    public void userClicksClosePopup() {
        shoppingCartPage.waitVisibilityOfElement(40, shoppingCartPage.getClosePopUp());
        shoppingCartPage.clickOnClosePopUp();
    }

    @Then("User checks that amount in cart is {string}")
    public void userChecksThatAmountInCartIsAmountInCart(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(40, homePage.getCartContainer());
        assertEquals(expectedAmount, homePage.getTextOfAmountProductsInCart());
    }

    @And("User clicks 'Sign in' button")
    public void userClicksSignInButton() {
        homePage.clickOnSignInPage();
    }

    @And("User enter wrong phone number")
    public void userEnterWrongPhoneNumber() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterWrongNumberToField();
    }

    @And("User clicks 'Continue' button")
    public void userClicksContinueButton() {
        signInPage.clickOnContinueButton();
    }

    @Then("User checks that {string} is appear on the page")
    public void userChecksThatErrorMessageIsAppearOnThePage(final String errorMessage) {
        assertTrue(signInPage.getIncorrectPhoneNumberMessage().contains(errorMessage));
    }

    @And("User clicks 'Gift cards' button")
    public void userClicksGiftCardsButton() {
        homePage.clickOnPopUpDeliveryAddress();
        homePage.clickOnGiftCardButton();
    }

    @And("User clicks 'Birthday' occasion")
    public void userClicksBirthdayOccasion() {
        giftCardPage = pageFactoryManager.getGiftCardPage();
        giftCardPage.clickOnBirthdayButton();
    }

    @And("User clicks 'EGift' button")
    public void userClicksEGiftButton() {
        giftCardPage.clickOnEGiftButton();
    }

    @And("User choose 'EGift' card type")
    public void userChooseEGiftCardType() {
        giftCardPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        giftCardPage.clickOnEGiftCard();
    }

    @When("User enter sentences in 'Message' field")
    public void userEnterSentencesInMessageField() {
        giftCardPage.enterMessageInField();
    }

    @Then("User checks that {string} is appear")
    public void userChecksThatWarningMessageIsAppear(final String warningMessage) {
        giftCardPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        giftCardPage.waitVisibilityOfElement(30, giftCardPage.getWarning());

        assertEquals(warningMessage, giftCardPage.getWarningMessage());
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.searchByKeyword(keyword);
    }

    @Then("User checks that page contains search keyword {string}")
    public void userChecksThatPageContainsSearchKeywordKeyword(final String keyword) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        for (WebElement webElement : searchResultPage.getSearchResultsList()) {
            assertTrue(webElement.getText().contains(keyword));
        }
    }

    @And("User clicks 'Change language'")
    public void userClicksChangeLanguage() {
        homePage.clickOnChangeLanguageButton();
    }

    @And("User clicks 'Select The currency'")
    public void userClicksSelectTheCurrency() {
        customerPreferencesPage = pageFactoryManager.getCustomerPreferencesPage();
        customerPreferencesPage.clickOnSelectTheCurrency();
    }

    @And("User select the currency in dropdown")
    public void userSelectTheCurrencyInDropdown() {
        customerPreferencesPage.clickOnSelectTheCurrencyInDropDown();
    }

    @When("User clicks 'Save changes' button")
    public void userClicksSaveChangesButton() {
        customerPreferencesPage.clickOnSaveChangesButton();
    }

    @Then("User checks that current url contains {string}")
    public void userChecksThatCurrentUrlContainsCurrency(final String currency) {
        assertTrue(driver.getCurrentUrl().contains(currency));
    }

    @And("User checks Carousel Row visibility")
    public void userChecksCarouselRowVisibility() {
        homePage.isCarouselRowVisible();
        assertTrue(homePage.isCarouselRowVisible());
    }

    @And("User checks 'Cart' Button visibility")
    public void userChecksCartButtonVisibility() {
        homePage.isCartButtonVisible();
        assertTrue(homePage.isCartButtonVisible());
    }

    @And("User checks 'Global Location' Button visibility")
    public void userChecksGlobalLocationButtonVisibility() {
        homePage.isGlobalLocationButtonVisible();
        assertTrue(homePage.isGlobalLocationButtonVisible());
    }

    @And("User checks 'SignIn' Page visibility")
    public void userChecksSignInPageVisibility() {
        homePage.isSignInButtonVisible();
        assertTrue(homePage.isSignInButtonVisible());
    }

    @And("User checks catalog Button visibility")
    public void userChecksCatalogButtonVisibility() {
        homePage.isCatalogButtonVisible();
        assertTrue(homePage.isCatalogButtonVisible());
    }

    @And("User checks 'CustomerService' button visibility")
    public void userChecksCustomerServiceButtonVisibility() {
        homePage.isCustomerServiceVisible();
        assertTrue(homePage.isCustomerServiceVisible());
    }

    @And("User checks 'Todays Deals' button visibility")
    public void userChecksTodaysDealsButtonVisibility() {
        homePage.isTodaysDealsVisible();
        assertTrue(homePage.isTodaysDealsVisible());
    }

    @And("User checks logo visibility")
    public void userChecksLogoVisibility() {
        homePage.isLogoVisible();
        assertTrue(homePage.isLogoVisible());
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
        assertTrue(homePage.isSearchFieldVisible());
    }

    @Then("User checks 'Gift Cards' button visibility")
    public void userChecksGiftCardsButtonVisibility() {
        homePage.isGiftCardsButtonVisible();
        assertTrue(homePage.isGiftCardsButtonVisible());
    }

    @And("User clicks on popUp delivery address")
    public void userClicksOnPopUpDeliveryAddress() {
        homePage.clickOnPopUpDeliveryAddress();
    }

    @And("User clicks catalog Button")
    public void userClicksCatalogButton() {
        homePage.clickOnCatalogButton();
    }

    @And("User clicks electronic section")
    public void userClicksElectronicSection() {
        menuPage = pageFactoryManager.getMenuPage();
        menuPage.waitVisibilityOfElement(30, menuPage.getElectronicButton());
        menuPage.clickOnElectronicButton();
    }

    @And("User clicks camera and photo section")
    public void userClicksCameraAndPhotoSection() {
        menuPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        menuPage.waitVisibilityOfElement(30, menuPage.getCameraAndPhotoButton());
        menuPage.clickOnCameraAndPhotoButton();
    }

    @When("User clicks main logo of the website")
    public void userClicksMainLogoOfTheWebsite() {
        menuPage.waitVisibilityOfElement(30, menuPage.getLogoButton());
        menuPage.clickOnMainLogo();
    }

    @Then("User checks that home page is open with {string}")
    public void userChecksThatHomePageIsOpenWithCurrentUrl(final String expectedHomePage) {
        assertTrue(driver.getCurrentUrl().contains(expectedHomePage));
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
