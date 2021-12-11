package com.opensource.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    private static final String PAGE_URL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    @FindBy(id="menu_admin_viewAdminModule")
    private WebElement adminMenu;

    private WebElement payGradesOpt;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void findPayGrades(){
        new Actions(driver).moveToElement(adminMenu).perform();
        WebElement jobMenu = new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.id("menu_admin_Job")));
        new Actions(driver).moveToElement(jobMenu).perform();
        payGradesOpt = new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.id("menu_admin_viewPayGrades")));

    }
    public void clickPayGradesOpt(){
        payGradesOpt.click();
    }
}
