package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapper {
    public static Boolean click_Youtube(WebElement ele, WebDriver driver){
        Boolean success;
        try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.elementToBeClickable(ele));
                Thread.sleep(2000);
                ele.click();
                success = true;
        }catch(Exception e){
            System.out.println("Exception occured while clicking:");
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static WebElement findElement_Youtube(By locator, WebDriver driver){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            return element;
            
        }
        catch(Exception e){
                System.out.println("Exception Occured!" + e. getMessage());
                return null;
                    }

}
public static void javaScroll(WebElement ele, WebDriver driver){
    try{
       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele); 
        Thread.sleep(2000);
        
    }
    catch(Exception e){
            System.out.println("Exception Occured!" + e. getMessage());
                }

}
}