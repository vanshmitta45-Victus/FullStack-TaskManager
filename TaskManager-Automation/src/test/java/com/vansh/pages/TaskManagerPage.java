package com.vansh.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TaskManagerPage {
    WebDriver driver;

    By titleInput = By.cssSelector("input[placeholder='Task Title']");
    By descInput = By.cssSelector("input[placeholder='Description']");
    By addBtn = By.cssSelector("button");

    public TaskManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTaskDetails(String title, String desc) {
        driver.findElement(titleInput).sendKeys(title);
        driver.findElement(descInput).sendKeys(desc);
    }

    public void clickAddButton() {
        driver.findElement(addBtn).click();
    }

    public boolean isTaskDisplayed(String taskTitle) {
        try {
            // 1. Create a Wait object (Wait up to 10 seconds)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 2. Tell Selenium to WAIT until the element is actually visible on the screen
            // We use "contains" instead of "text=" to be more flexible
            WebElement taskElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h3[contains(text(), '" + taskTitle + "')]")
            ));

            return taskElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("Task not found within the time limit: " + e.getMessage());
            return false;
        }
    }
}
