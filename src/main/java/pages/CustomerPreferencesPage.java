package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPreferencesPage extends BasePage{

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement selectTheCurrency;

    @FindBy (xpath = "//a[@data-value='{\"stringVal\":\"AED\"}']")
    private WebElement selectTheCurrencyInDropdown;

    @FindBy (xpath = "//input[@class='a-button-input']")
    private WebElement saveChangesButton;


    public CustomerPreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSelectTheCurrency(){
        selectTheCurrency.click();
    }

    public void clickOnSelectTheCurrencyInDropDown(){
        selectTheCurrencyInDropdown.click();
    }

    public void clickOnSaveChangesButton(){
        saveChangesButton.click();
    }

}
