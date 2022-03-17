package assigments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {
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


        WebElement chooseFlight = driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[2]"));
        chooseFlight.click();


        WebElement name = driver.findElement(By.id("inputName"));
        name.sendKeys("John Doe");
        name.click();
        Thread.sleep(2000);

        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("Address | 123 Washington ave.");
        address.click();
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("New York");
        Thread.sleep(1000);
        city.click();
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("NY");
        state.click();
        WebElement cardType = driver.findElement(By.id("cardType"));
        cardType.sendKeys("12345");
        cardType.click();
        Thread.sleep(2000);
        cardType.findElement(By.xpath("//select[@id='cardType']/option[1]"));


        WebElement cardNumber = driver.findElement(By.id("creditCardNumber"));
        cardNumber.sendKeys("1234567890 ");
        cardNumber.click();
        Thread.sleep(2000);
        WebElement month = driver.findElement(By.id("creditCardMonth"));
        month.sendKeys("11");
        month.click();
        WebElement year = driver.findElement(By.id("creditCardYear"));
        year.sendKeys("2025");
        year.click();
        Thread.sleep(2000);
        WebElement nameOnCard = driver.findElement(By.id("nameOnCard"));
        nameOnCard.sendKeys("John Doe");
        nameOnCard.click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actual = driver.findElement(By.tagName("h1")).getText();
        String expected = "Thank you for your purchase today!";

        Assert.assertEquals(actual, expected);

        List<WebElement> actualNumber = driver.findElements(By.id("creditCardNumber"));
        for (int i = 5; i < actualNumber.size(); i++) {
            for (int a = 5; a < actualNumber.size(); a++) {
                if (actualNumber.get(i).equals(actualNumber.get(a))) ;
                System.out.println("Last four digits matching with proved card");

            }

        }
        String actual1 = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[7]/td[2]")).getText();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate localDate1 = LocalDate.parse(actual1.substring(5, 16), formatter);

        Assert.assertEquals(localDate1, date);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}