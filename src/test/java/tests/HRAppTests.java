package tests;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HRAppLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class HRAppTests extends TestBase {
    @DataProvider(name = "loginData")
    public static Object[][] loginData(){
        Object[][] data = new Object[][]{
                {"Mindtek", "mindtekstudent"},
                {"mindtekkkk67", "MindtekStudent"}
        };
        return data;
    }

    @Test
    public void validateLoginPositive(){
        driver.get(ConfigReader.getProperty("HRAppURL"));
        HRAppLoginPage loginPage = new HRAppLoginPage();

        loginPage.username.sendKeys("Mindtek");
        loginPage.password.sendKeys("MindtekStudent");
        loginPage.loginButton.click();

        String actualResult=driver.findElement(By.xpath("//label[@for='departments']")).getText();
        String expectedResult="Select Department";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

    }
    @Test (dataProvider = "loginData")
    public void validateLoginNegative(String username, String password){
        driver.get(ConfigReader.getProperty("HRAppURL"));
        HRAppLoginPage loginPage = new HRAppLoginPage();

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();

        String actualResult=driver.findElement(By.xpath("//div[@class='alert alert-waring']")).getText();
        String expectedResult="Invalid credentials";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

    }

}