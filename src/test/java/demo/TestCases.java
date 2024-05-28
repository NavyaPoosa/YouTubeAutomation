package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases {
    WebDriver driver;

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
        SeleniumWrapper.javaScroll(textDisplay,driver);
        Thread.sleep(2000);
        System.out.println(textDisplay.getText());
        

        System.out.println("End Test case: Testcase01");
    }
    
    @Test
    public void testcase02() throws InterruptedException{
        System.out.println("Start Test case: Testcase02");
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement filmButton = SeleniumWrapper.findElement_Youtube(By.xpath("//yt-formatted-string[text()='Movies']"), driver);
        Boolean testflow01 = SeleniumWrapper.click_Youtube(filmButton, driver);
        Assert.assertEquals(testflow01, true);

        WebElement nextButton = SeleniumWrapper.findElement_Youtube(By.xpath("//button[@aria-label='Next']//div[@class='yt-spec-touch-feedback-shape__fill']"),driver);
    
        
            for(int i=0;i<3;i++){
                if(nextButton.isEnabled()){
                    nextButton.click();
                    Thread.sleep(1000);
              }  
            }
        
        WebElement movie = SeleniumWrapper.findElement_Youtube(By.xpath("//span[@title='The Wolf of Wall Street']/ancestor::a/span"), driver);
       Thread.sleep(1000);
        Boolean testflow02 = movie.getText().contains("Comedy");
       Assert.assertEquals(testflow02, true);
       System.out.println("End Test case: Testcase02");
    }
   
     @AfterClass
    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

}
