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
import org.testng.asserts.SoftAssert;

public class TestCases {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

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

        // open the url and verify
        driver.get("https://www.youtube.com/");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.youtube.com/", "Youtube is not opened");

        // scroll to the element
        WebElement aboutButton = SeleniumWrapper
                .findElement_Youtube(By.xpath("//div[@id='guide-links-primary']//a[text()='About']"), driver);
        SeleniumWrapper.javaScroll(aboutButton, driver);

        // click on "About" at the bottom of sidebar
        Boolean testflow01 = SeleniumWrapper.click_Youtube(aboutButton, driver);
        Assert.assertEquals(testflow01, true, "About link is not clicked");

        // print the text displayed on the About page
        WebElement textDisplay = SeleniumWrapper.findElement_Youtube(By.xpath("//section[@class='ytabout__content']"),
                driver);
        SeleniumWrapper.javaScroll(textDisplay, driver);
        System.out.println("Printing the message displayed on the screen: " + textDisplay.getText());

        System.out.println("End Test case: Testcase01");
    }

    @Test
    public void testcase02() throws InterruptedException {
        System.out.println("Start Test case: Testcase02");

        // Navigate to the home page
        driver.navigate().back();

        // click on movie tab
        WebElement movieTab = SeleniumWrapper.findElement_Youtube(By.xpath("//yt-formatted-string[text()='Movies']"),
                driver);
        Boolean testflow01 = SeleniumWrapper.click_Youtube(movieTab, driver);
        Assert.assertEquals(testflow01, true, "movie tab is not clicked");

        // scroll to the extreme right
        WebElement nextButton = SeleniumWrapper.findElement_Youtube(
                By.xpath("//button[@aria-label='Next']//div[@class='yt-spec-touch-feedback-shape__fill']"), driver);

        for (int i = 0; i < 3; i++) {
            if (nextButton.isEnabled()) {
                nextButton.click();
                Thread.sleep(1000);
            }
        }

        // Apply a Soft Assert on whether the movie is marked “A” for Mature or not.
        WebElement movieMarked = SeleniumWrapper.findElement_Youtube(By.xpath(
                "//span[@title='The Wolf of Wall Street']/ancestor::a/following-sibling::ytd-badge-supported-renderer/div[@aria-label='A']/p"),
                driver);
        softAssert.assertTrue(movieMarked.getText().equals("A"),"Movie is not marked as 'A'");

        // Apply a Soft assert on whether the movie is either “Comedy” or “Animation”.
        WebElement movie = SeleniumWrapper
                .findElement_Youtube(By.xpath("//span[@title='The Wolf of Wall Street']/ancestor::a/span"), driver);
        softAssert.assertTrue(movie.getText().contains("Comedy") || movie.getText().contains("Animation"), "Text is Nither 'Comedy' or 'Animation'");

        System.out.println("End Test case: Testcase02");
    }

    @Test
    public void testcase03() throws InterruptedException {
        System.out.println("Start Test case: Testcase03");

        // click on music tab
        WebElement musicTab = SeleniumWrapper.findElement_Youtube(By
                .xpath("//yt-formatted-string[@class='title style-scope ytd-guide-entry-renderer' and text()='Music']"),
                driver);
        Boolean testFlow01 = SeleniumWrapper.click_Youtube(musicTab, driver);
        Assert.assertEquals(testFlow01, true, "Music tab is not clicked");

        // scroll the page till home tab
        WebElement home = driver.findElement(By.xpath("//div[text()='Home']"));
        SeleniumWrapper.javaScroll(home, driver);

        // scroll to the extreme right.
        WebElement nextButton = SeleniumWrapper.findElement_Youtube(
                By.xpath("(//button[@aria-label='Next']//div[@class='yt-spec-touch-feedback-shape__fill'])[2]"),
                driver);

        for (int i = 0; i < 3; i++) {
            if (nextButton.isEnabled()) {
                nextButton.click();
                Thread.sleep(1000);
            }
        }

        // Print the name of the playlist.
        WebElement playlistName = SeleniumWrapper
                .findElement_Youtube(By.xpath("//h3[normalize-space()='Bollywood Dance Hitlist']"), driver);
        String listName = playlistName.getText();
        System.out.println("Name of the playlist: " +listName);
       

        // Soft Assert on whether the number of tracks listed is less than or equal to 50.
        WebElement tracks = SeleniumWrapper.findElement_Youtube(
                By.xpath("//h3[normalize-space()='Bollywood Dance Hitlist']//parent::a/p"), driver);
        String str = tracks.getText();
        str = str.replaceAll("[^0-9]", " ");
        str = str.trim();
        int num = Integer.parseInt(str);
        softAssert.assertTrue((num <= 50), "The no.of tracks listed is less than or equal to 50");
    
        System.out.println("End Test case: Testcase03");
    }

    @AfterClass
    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

}
