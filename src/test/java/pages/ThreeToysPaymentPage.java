package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ThreeToysPaymentPage {
    public ThreeToysPaymentPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//select[@name='quantity']//option[@value='3']")
    public WebElement threeQuantity;
    @FindBy(xpath = "//input[@value='Buy Now']")
    public WebElement buyNowButton;

    public void buyThreeToys(){
        threeQuantity.click();
        buyNowButton.click();
    }
}
