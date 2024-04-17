package POM.Tests;

import POM.Pages.LoginPage;
import POM.Pages.ProductPage;
import baseTestCase.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SuccessfulLogout extends TestUtil {
    @Test
    public void successfulLogout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(productPage.isAt());

        productPage.logout();
        softAssert.assertTrue(loginPage.isAt());

        softAssert.assertAll();
    }
}
