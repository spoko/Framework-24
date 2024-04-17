package productTests;

import baseTestCase.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddItemsToTheCart extends TestUtil {

    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";
    @Test
    public void addItemsToTheCart(){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();

        WebElement item1 = driver.findElement(By.id(BASE_PRODUCT_ID + "bike-light"));
        item1.click();

        SoftAssert softAssert = new SoftAssert();

        WebElement shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        softAssert.assertEquals(shoppingCartBadge.getText(), "1", "Because this is the first items");

        WebElement item2 = driver.findElement(By.id(BASE_PRODUCT_ID + "backpack"));
        item2.click();

        softAssert.assertEquals(shoppingCartBadge.getText(), "26", "Because we added two elements so far");

        softAssert.assertAll();
    }
}
