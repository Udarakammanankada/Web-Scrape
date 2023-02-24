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
        System.setProperty("webdriver.chrome.driver", "add the path to chromedriver exe");
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
        // Fine the web element
        WebElement contentElement = driver.findElement(By.id("mw-content-text"));
        // Pass the content to string file and print it
        String content = contentElement.getText();
        System.out.println("content is: " + content);

        // Write the content to a text file

        try {
            FileWriter writer = new FileWriter("Add the path of the text file");
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
