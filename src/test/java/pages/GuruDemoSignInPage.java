package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GuruDemoSignInPage {
    public GuruDemoSignInPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="email")
    public WebElement emailLogin;

    @FindBy(id="passwd")
    public WebElement passwordLogin;

    @FindBy(id="SubmitLogin")
    public WebElement sighIn;

     @FindBy(tagName = "h3")
     public  WebElement message;


    public void loginDemoGuru(){
        Driver.getDriver().get(ConfigReader.getProperty("GuruDemoURL"));
        emailLogin.sendKeys("admin@mindtek.com");
        passwordLogin.sendKeys("admin");
        sighIn.click();
    }




}
