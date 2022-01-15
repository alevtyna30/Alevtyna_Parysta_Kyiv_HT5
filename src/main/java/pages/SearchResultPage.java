package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> searchResultsProductsListText;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsProductsListText;
    }

}
