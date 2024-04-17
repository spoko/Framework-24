package POM.Tests;

import POM.Pages.*;
//import POM.Pages.ProductPage;
import baseTestCase.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLogin extends TestUtil {
    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isAt());
    }
}
