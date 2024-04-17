package POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{
    @FindBy(className = "title")
    private WebElement productPageTitle;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement navMenu;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutBtn;


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return productPageTitle.isDisplayed();
    }

    public LoginPage logout(){
        navMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));

        logOutBtn.click();

        return new LoginPage(driver);
    }
}
