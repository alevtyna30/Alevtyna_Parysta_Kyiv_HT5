package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardPage extends BasePage{

    @FindBy(xpath = "//img[@alt='Birthday Gift Cards']")
    private WebElement birthdayButton;

    @FindBy(xpath = "//a[@id='a-autoid-0-announce']")
    private WebElement eGiftButton;

    @FindBy(xpath = "//img[@class='s-image']")
    private WebElement eGiftCard;

    @FindBy(xpath = "//textarea[@id='gc-order-form-message']")
    private WebElement messageField;

    @FindBy(xpath = "//div[@class='a-box a-alert-inline a-alert-inline-error gc-inline-error']")
    private WebElement warning;

    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBirthdayButton(){
        birthdayButton.click();
    }

    public void clickOnEGiftButton(){
        eGiftButton.click();
    }

    public void clickOnEGiftCard(){
        eGiftCard.click();
    }

    public void enterMessageInField(){
        messageField.clear();
        messageField.sendKeys("It is a long established fact that a reader will be distracted by " +
                "the readable content of a page when looking at its layout. The point of using Lorem Ipsum " +
                "is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, " +
                "content here', making it look like readable English. Many desktop publishing packages and " +
                "web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' " +
                "will uncover many web sites still in their infancy. Various versions have evolved over the years, " +
                "sometimes by accident, sometimes on purpose (injected humour and the like).");
    }

    public String getWarningMessage(){
        return warning.getText();
    }

    public WebElement getEGiftCard(){
        return eGiftCard;
    }

    public WebElement getWarning(){
        return warning;
    }

}
