package loginTests;

import baseTestCase.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UnSuccessfulLogin extends TestUtil {
    @Test(dataProvider = "wrongUsers")
    public void successfulLogin(String username, String password) {
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();

        WebElement errorMsgBtn = driver.findElement(By.cssSelector(".error-button"));
        Assert.assertTrue(errorMsgBtn.isDisplayed());
    }

    @DataProvider(name = "wrongUsers")
    public Object[][] readWrongUsers(){
        try{
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataResult = new Object[csvData.size()][2];

            for (int i=0; i< csvData.size(); i++){
                csvDataResult[i] = csvData.get(i);
            }

            return csvDataResult;
        }catch (IOException e){
            System.out.println(e);
            return null;
        } catch (CsvException e) {
            System.out.println(e);
            return null;
        }
    }
}
