package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class demo {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a WebDriver instance (in this case, ChromeDriver)
        WebDriver driver = new ChromeDriver();

        // Open your application and navigate to the page with the navigation menu
        driver.get("https://your-application-url");

        // Define a HashMap for menu items and their corresponding link texts
        Map<String, String> menuItems = new HashMap<>();
        menuItems.put("Home", "Home");
        menuItems.put("About Us", "About Us");
        menuItems.put("Products", "Products");
        menuItems.put("Contact", "Contact");

        // Navigate to different sections using the navigation menu
        navigateToSection(driver, "mainMenu", menuItems, "About Us");

        // Perform additional actions or validations after navigating
        // ...

        // Close the browser
        driver.quit();
    }

    private static void navigateToSection(WebDriver driver, String menuId, Map<String, String> items, String section) {
        // Find the menu element based on its ID
        WebElement menu = driver.findElement(By.id(menuId));

        // Find the link text associated with the specified section in the HashMap
        String linkText = items.get(section);

        // Find the corresponding link element and click on it
        WebElement sectionLink = menu.findElement(By.xpath(".//a[text()='" + linkText + "']"));
        sectionLink.click();
    }
    }



