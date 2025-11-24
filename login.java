package loginautomationnewx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class login{
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testapp.cflowapps.com/cflow/login");  // ← put your URL here

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Client ID
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-id"))).sendKeys("cflowtestAP.com");

        // Username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("automationtestingAP@cflowtestAP.com");

        // Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Nalina@123");

        // Login button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button-login"))).click();

        System.out.println("Login Completed Successfully!");
        
        Thread.sleep(3000);

        // PRINT URL after login
        String actualUrl = driver.getCurrentUrl();
        System.out.println("After login URL: " + actualUrl);

        // VERIFY URL
        String expectedUrl = "https://testapp.cflowapps.com/cflow/dashboard";

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("SUCCESS: Dashboard page verified!");
        } else {
            System.out.println("FAILED: Dashboard NOT verified.");
            System.out.println("Expected: " + expectedUrl);
            System.out.println("Actual  : " + actualUrl);
        }

        driver.quit();
        
    }
}
