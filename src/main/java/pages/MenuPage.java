package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-menu-id='6']")
    private WebElement computersButton;

    @FindBy(xpath = "//a[text()='Monitors']")
    private WebElement monitorsButtons;

    @FindBy(xpath = "//a[@id='p_89/HP']")
    private WebElement chooseBrandOnTheFilter;

    @FindBy(xpath = "//li[@id='p_89/HP']")
    private WebElement chooseBrandOnTheFilterSecond;

    @FindBy(xpath = "//a[@data-menu-id='5']")
    private WebElement electronicButton;

    @FindBy(xpath = "//a[@href='/s?bbn=16225009011&rh=i%3Aspecialty-aps%2Cn%3A%2116225009011%2Cn%3A502394&ref_=nav_em__nav_desktop_sa_intl_camera_and_photo_0_2_5_3']")
    private WebElement cameraAndPhotoButton;

    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement logo;

    public void clickOnComputersButton(){
        computersButton.click();
    }

    public WebElement getClickOnComputersButton(){
        return computersButton;
    }

    public void clickOnMonitorsButton(){
        monitorsButtons.click();
    }

    public void applyTheFilter(){
        if (chooseBrandOnTheFilter.isDisplayed()) {
            chooseBrandOnTheFilter.click();
        } else {
            chooseBrandOnTheFilterSecond.click();
        }
    }

    public WebElement getChooseBrandOnTheFilter(){
        return chooseBrandOnTheFilter;
    }

    public void clickOnElectronicButton(){
        electronicButton.click();
    }

    public void clickOnCameraAndPhotoButton(){
        cameraAndPhotoButton.click();
    }

    public void clickOnMainLogo(){
        logo.click();
    }

    public WebElement getCameraAndPhotoButton(){
        return cameraAndPhotoButton;
    }

    public WebElement getLogoButton(){
        return logo;
    }

    public WebElement getElectronicButton(){
        return electronicButton;
    }

}

