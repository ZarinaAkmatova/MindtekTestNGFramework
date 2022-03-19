package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GuruPaymentGetawayProjectPage {
    public GuruPaymentGetawayProjectPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//a[@href='http://demo.guru99.com/payment-gateway/index.php']")
    public WebElement paymentGateway;

    @FindBy(xpath = "//input[@value='Buy Now']")
    public WebElement buyNow;

    @FindBy(xpath = "//font[@color='red'] ")
    public WebElement payAmount;

    @FindBy(xpath = "//img[@src='images/visa.png'] ")
    public WebElement visa;

    @FindBy(id = "card_nmuber")
    public WebElement cardNumber;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(id = "cvv_code")
    public WebElement cvvCode;

    @FindBy(xpath = "//input[@name='submit'] ")
    public WebElement submit;

    @FindBy(tagName = "h2")
    public WebElement paymentMessage;

    public void checkOut() {
        buyNow.click();
        payAmount.getText();
        visa.click();
        cardNumber.sendKeys("1234567891234567");
        month.sendKeys("02");
        year.sendKeys("2021");
        cvvCode.sendKeys("1234");
        submit.click();
        paymentMessage.getText();
    }

}
