package com.opensource.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayGradeAddNamePage {
    private final WebDriver driver;

    private static final String PAGE_URL="https://opensource-demo.orangehrmlive.com/index.php/admin/payGrade";

    @FindBy(id="payGrade_name")
    private WebElement nameField;

    @FindBy(id="btnSave")
    private WebElement saveBtn;

    public PayGradeAddNamePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickSaveBtn(){
        saveBtn.click();
    }
    public void fillNameField(String username){
        nameField.sendKeys(username);
    }

}
