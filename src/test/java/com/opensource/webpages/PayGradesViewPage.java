package com.opensource.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class PayGradesViewPage{
    private final WebDriver driver;

    private static final String PAGE_URL="https://opensource-demo.orangehrmlive.com/index.php/admin/viewPayGrades";

    @FindBy(id="btnAdd")
    private WebElement addBtn;

    @FindBy(id="btnDelete")
    private WebElement deleteBtn;

    public PayGradesViewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAddBtn(){
        addBtn.click();
    }
    public void clickDeleteBtn(){
        deleteBtn.click();
    }
    public String[] searchUserDataById(String userId){
        WebElement createdUser = driver.findElement(By.xpath("//a[@href='payGrade?payGradeId="+userId+"']/parent::*/parent::*"));
        return createdUser.getAttribute("innerText").split("\t");
    }
    public boolean checkUserName(String name, String foundName){
        return (Objects.equals(name, foundName));
    }
    public boolean checkCurrency(String currency,String foundCurrency ){
        return (Objects.equals(currency, foundCurrency));
    }

    public void tickPayGradeToDelete(String userId){
        driver.findElement(By.id("ohrmList_chkSelectRecord_"+userId)).click();
    }
    public void confirmDelete(){
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }
    public boolean checkDeletion(String userId){
        return driver.findElements(By.xpath("//a[@href='payGrade?payGradeId="+userId+"']")).isEmpty();
    }
}
