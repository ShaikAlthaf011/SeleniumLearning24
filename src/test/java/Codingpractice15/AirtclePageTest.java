package Codingpractice15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AirtclePageTest {
    public static <WebDriverwait> void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaarticlervw.ccbp.tech/article/");
        driver.manage().window().maximize();
        WebElement el1= driver.findElement(By.cssSelector("h1[class='article-details-title']"));
        System.out.println(el1.getText());
        WebElement el2= driver.findElement(By.cssSelector("button[class='review-btn']"));
        el2.click();
        String Str1="https://qaarticlervw.ccbp.tech/review";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(Str1));
       String Str2= driver.getCurrentUrl();
       if(Str1.equals(Str2)){
           System.out.println("Navigated to Review page");
       }
       WebElement el3= driver.findElement(By.cssSelector("div[id='root']>div>textarea"));
       el3.sendKeys("Clear and thoughtful explanation of React's versioning approach.");
       wait.until(ExpectedConditions.elementToBeClickable(el3));
       WebElement el4= driver.findElement(By.cssSelector("div[id='root']>div>button"));
       el4.click();
       wait.until(ExpectedConditions.urlToBe("https://qaarticlervw.ccbp.tech/article"));
       String Str3= driver.getCurrentUrl();
       String Str4="https://qaarticlervw.ccbp.tech/article";
       if(Str3.equals(Str4)){
           System.out.println("Navigated to Article page");

       }
       driver.quit();
      }
}
