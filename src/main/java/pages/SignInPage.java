package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement fillField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement incorrectPhoneNumberMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterWrongNumberToField(){
        fillField.sendKeys("896");
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public String getIncorrectPhoneNumberMessage(){
        return incorrectPhoneNumberMessage.getText();
    }

}
