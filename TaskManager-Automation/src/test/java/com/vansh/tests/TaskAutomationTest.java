package com.vansh.tests;

import com.vansh.pages.TaskManagerPage; // Import the Page Object we created above
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TaskAutomationTest {
    WebDriver driver;
    TaskManagerPage taskPage;

       @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        
        // --- ADD THESE LINES FOR CI/CD SUPPORT ---
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--headless"); // Runs Chrome without a UI (Essential for GitHub Actions)
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems in Docker
        options.addArguments("--window-size=1920,1080"); // Set a standard screen size
        // ------------------------------------------

        driver = new ChromeDriver(options); // Pass the options to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:5173");

        taskPage = new TaskManagerPage(driver);
    }

    @Test
    public void testAddNewTaskSuccessfully() {
        String myTitle = "Professional POM Task";
        String myDesc = "This test is running using the Page Object Model!";

        // Action: Enter details and click add
        taskPage.enterTaskDetails(myTitle, myDesc);
        taskPage.clickAddButton();

        // Verification: Check if the task is actually on the screen
        boolean isPresent = taskPage.isTaskDisplayed(myTitle);

        Assert.assertTrue(isPresent, "The task was not found on the UI!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
