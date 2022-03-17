package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GuruDemoSignInPage;
import pages.GuruPaymentGetawayProject;
import utilities.ConfigReader;
import utilities.TestBase;

public class GuruDemoTest extends TestBase {
    GuruDemoSignInPage demo = new GuruDemoSignInPage();
    GuruPaymentGetawayProject payment=new GuruPaymentGetawayProject();

    @Test
    public void firstTest() {

        demo.loginDemoGuru();
        String actualMessage = demo.message.getText();
        String expectedMessage = "Successfully Logged in...";
        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @Test
    public void secondTest(){
        demo.loginDemoGuru();
        payment.paymentGateway.click();
        payment.checkOut();
        String actual=payment.paymentMessage.getText();
        String expected="Payment successfull!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void thirdTest(){
        demo.loginDemoGuru();
        payment.paymentGateway.click();





    }
}
