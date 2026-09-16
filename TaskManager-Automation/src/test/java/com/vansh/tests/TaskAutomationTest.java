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
        // 1. Setup Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 2. Open the React App
        driver.get("http://localhost:5173");

        // 3. Connect the test to the Page Object
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
