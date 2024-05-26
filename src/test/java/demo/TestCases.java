package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases {
    ChromeDriver driver;

   @BeforeClass
    public void setup() {
        System.out.println("Constructor: Driver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        System.out.println("Successfully created Driver");
    }

   @Test
    public void testcase01() throws InterruptedException {
        System.out.println("Start Test case: Testcase01");

        //open the url and verify 
        driver.get("https://www.youtube.com/");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.youtube.com/");
        
        //scroll to the element
        WebElement aboutButton =SeleniumWrapper.findElement_Youtube(By.xpath("//div[@id='guide-links-primary']//a[text()='About']"), driver);
        SeleniumWrapper.javaScroll(aboutButton, driver);
        
        //click on "About"
        Boolean testflow01= SeleniumWrapper.click_Youtube(aboutButton, driver);
        Assert.assertEquals(testflow01, true);    

        //print the text dispalyed on the About page 
        WebElement textDisplay = SeleniumWrapper.findElement_Youtube(By.xpath("//section[@class='ytabout__content']"), driver);
        SeleniumWrapper.javaScroll(textDisplay, driver);
        System.out.println(textDisplay.getText());

        System.out.println("End Test case: Testcase01");
    }


    @AfterClass
    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

}
