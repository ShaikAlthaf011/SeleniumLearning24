package Codingpractice15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewsLetterSubscriptionPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qanewsltrpls.ccbp.tech/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement el1= driver.findElement(By.cssSelector("div[id='app']>div>div>div:nth-child(2)>input"));
        el1.sendKeys("John Doe");
        WebElement el2= driver.findElement(By.cssSelector("div[id='app']>div>div>div:nth-child(2)>button"));
        el2.click();
        WebElement el3= driver.findElement(By.cssSelector("div[id='app']>div>div:nth-child(2)>div>input"));
        el3.sendKeys("9876543210");
        WebElement el4= driver.findElement(By.cssSelector("div[id='app']>div>div:nth-child(2)>div>button"));
        el4.click();
        WebElement el5= driver.findElement(By.cssSelector("div[id='app']>div>div:nth-child(3)>div>input"));
        el5.sendKeys("johndoe@gmail.com");
        WebElement el6= driver.findElement(By.cssSelector("div[id='app']>div>div:nth-child(3)>div>button"));
        el6.click();
        WebElement el7= driver.findElement(By.cssSelector("div[id='app']>div>div:nth-child(4)>button"));
        el7.click();
        System.out.println("Scucess Message");
    }


}
