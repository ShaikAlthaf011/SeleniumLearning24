package Codingpractice15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RecipePageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qarecipepage.ccbp.tech/");
        driver.manage().window().maximize();
        // Declare a Fluent Wait for a maximum of '5' Seconds and polling every '500' milliseconds
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));

        // Find the Recipe Category List elements
        List<WebElement> categoryList = driver.findElements(By.cssSelector("li"));

        for (WebElement category : categoryList) {

            // Click the Recipe Category
            category.click();

            // Wait until the Recipe List is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#recipeList li")));

            // Find the Recipe List elements
            List<WebElement> recipeList = driver.findElements(By.cssSelector("div#recipeList li"));

            for (WebElement recipe : recipeList) {

                // Click the Recipe
                recipe.click();

                // Wait until the Recipe is visible
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#recipe>h3")));

                // Print the Recipe Name
                WebElement recipeEle = driver.findElement(By.cssSelector("div#recipe>h3"));
                System.out.println(recipeEle.getText());

                // Print the Recipe Ingredients
                List<WebElement> ingredientsList = driver.findElements(By.cssSelector("div#recipe>ul>li"));
                for (WebElement ingredient : ingredientsList) {
                    System.out.println(ingredient.getText());
                }
            }
        }

        // Quit the WebDriver instance

    }
}
