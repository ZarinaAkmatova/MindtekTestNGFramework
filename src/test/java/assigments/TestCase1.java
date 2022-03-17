package assigments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestCase1 {

    WebDriver driver;

    @BeforeMethod
    public void launchUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void start() throws InterruptedException {
        driver.get("https://blazedemo.com/");
        WebElement fromCity = driver.findElement(By.name("fromPort"));
        Select select = new Select(fromCity);
        select.selectByValue("San Diego");
        Thread.sleep(5000);


        WebElement toCity = driver.findElement(By.name("toPort"));
        Select select2 = new Select(toCity);
        select2.selectByValue("New York");

        WebElement sumbit = driver.findElement(By.tagName("input"));
        sumbit.click();


        WebElement chooseFlight = driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[1]"));
        chooseFlight.click();

        Thread.sleep(2000);


        WebElement name = driver.findElement(By.id("inputName"));
        name.sendKeys("David Clark");


        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("Address 123 Washington ave.");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Austin");

        Thread.sleep(1000);
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("TX");

        WebElement cardType = driver.findElement(By.id("cardType"));
        cardType.sendKeys("American Express");

        cardType.findElement(By.xpath("//select[@id='cardType']/option[2]"));

        Thread.sleep(2000);
        WebElement cardNumber = driver.findElement(By.id("creditCardNumber"));
        cardNumber.sendKeys("mycreditcardnum");

        WebElement month = driver.findElement(By.id("creditCardMonth"));
        month.sendKeys("Month 11");

        WebElement year = driver.findElement(By.id("creditCardYear"));
        year.sendKeys("Year 2025");

        WebElement nameOnCard = driver.findElement(By.id("nameOnCard"));
        nameOnCard.sendKeys("David Clark");

        Thread.sleep(2000);


        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actual = driver.findElement(By.tagName("h1")).getText();

        String expected = "Invalid credit card number! ";
        Assert.assertEquals(actual, expected);


    }


}
