package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StoreAppCartPage;
import pages.StoreAppHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

import java.io.IOException;

public class storeAppAddCartFunctionalityTests extends TestBase {

    @Test
    public void validateAddCardFunctionalityTest() throws InterruptedException, IOException {
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,200)");
        BrowserUtils.scrollUpOrDown(300);
        StoreAppHomePage homePage = new StoreAppHomePage();
        BrowserUtils.hoverOver(homePage.product1);
        homePage.product1AddCart.click();
        Thread.sleep(10000);
        BrowserUtils.takeScreenShot();

        String actualMessage = homePage.addCartSuccessMessage.getText();
        String expectedMessage = "Product successfully added to your shopping cart";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage);

        Thread.sleep(5000);
        String addedProductName=homePage.addedProductName.getText();
        Thread.sleep(5000);
        homePage.closeWindowIcon.click();
        Thread.sleep(5000);
        homePage.cart.click();

        StoreAppCartPage cartPage=new StoreAppCartPage();
        String addedProductNameInCart=cartPage.productName.getText();

        softAssert.assertEquals(addedProductNameInCart,addedProductName);

        softAssert.assertAll();


    }

}
