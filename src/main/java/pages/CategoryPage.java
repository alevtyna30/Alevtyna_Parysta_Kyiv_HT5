package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{

    @FindBy(xpath = "//img[@alt='Pokémon Assorted Cards, 50 Pieces']")
    private WebElement productButton;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductButton(){
        productButton.click();
    }

}
