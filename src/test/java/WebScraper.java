import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable file
        System.setProperty("webdriver.chrome.driver", "/home/vetstoria/udara/Udara/webdriver/chromedriver_linux64/chromedriver");
        // Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);


        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the website you want to scrape
        driver.get("https://en.wikipedia.org/wiki/Sri_Lanka");

        // Find and print the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find and print the page header
        WebElement contentElement = driver.findElement(By.id("mw-content-text"));
        String content = contentElement.getText();
        System.out.println("content is: " + content);


        try {
            FileWriter writer = new FileWriter("/home/vetstoria/udara/Udara/Restassured write/file2.txt");
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
