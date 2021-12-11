package com.opensource.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayGradeAddCurrencyPage {
    private final WebDriver driver;

    @FindBy(id="btnAddCurrency")
    private WebElement addCurrencyBtn;

    @FindBy(id="payGradeCurrency_currencyName")
    private WebElement currencyNameField;

    @FindBy(id="payGradeCurrency_minSalary")
    private WebElement minSalaryField;

    @FindBy(id="payGradeCurrency_maxSalary")
    private WebElement maxSalaryField;

    @FindBy(id="btnSaveCurrency")
    private WebElement saveCurrencyBtn;

    @FindBy(id="payGrade_payGradeId")
    private WebElement payGrade;


    public String getUserId(){
        return payGrade.getAttribute("defaultValue");
    }

    public PayGradeAddCurrencyPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAddCurrencyBtn(){
        addCurrencyBtn.click();
    }
    public void clickSaveCurrencyBtn(){
        saveCurrencyBtn.click();
    }
    public void fillCurrencyNameField(String currency){
        currencyNameField.sendKeys(currency);
    }
    public void fillMinSalaryField(String minSalary){
        minSalaryField.sendKeys(minSalary);
    }
    public void fillMaxSalaryField(String maxSalary){
        maxSalaryField.sendKeys(maxSalary);
    }
    public boolean searchCurrency(){
        return driver.findElements(By.xpath("//*[text()='No Records Found']")).isEmpty();
    }

}
