package Codingpractice15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentGateWayPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qapaygate.ccbp.tech/");
        driver.manage().window().maximize();
        WebElement el1= driver.findElement(By.cssSelector("input[id='cardNumber']"));
        el1.sendKeys("1234567891234569");
        WebElement el2= driver.findElement(By.cssSelector("input[id='expiryDate']"));
        el2.sendKeys("12/23");
        WebElement el3= driver.findElement(By.cssSelector("input[id='cvv']"));
        el3.sendKeys("123");
        WebElement el4= driver.findElement(By.cssSelector("button[id='payNowBtn']"));
        el4.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='otp']")));
        WebElement el5= driver.findElement(By.cssSelector("input[id='otp']"));
        el5.sendKeys("123456");
        WebElement el6= driver.findElement(By.cssSelector("button[id='verifyBtn']"));
        el6.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='verifyBtn']")));
        System.out.println("Success Message");
    }

}
