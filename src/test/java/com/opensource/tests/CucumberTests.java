package com.opensource.tests;

import com.opensource.webpages.*;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(publish = true)
public class CucumberTests {
    private static ChromeDriver driver;
    private static String name;
    private static String currency;
    private static String userId;
    private SignInPage signIn;
    private HomePage home;
    private PayGradesViewPage viewPayGrades;
    private PayGradeAddNamePage addNameGrade;
    private PayGradeAddCurrencyPage addCurrency;

    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "C:\\Labs\\DevelopTest\\something\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("User on {string} page")
    public void user_on_page(String page) {
        switch (page) {
            case "Home" -> home = new HomePage(driver);
            case "Authentication" -> signIn = new SignInPage(driver);
            case "PayGrades" -> viewPayGrades = new PayGradesViewPage(driver);
            case "AddCurrency" -> addCurrency = new PayGradeAddCurrencyPage(driver);
        }
    }
    @When("User tabs {string}")
    public void user_tabs(String value) {
        switch (value) {
            case ("username") -> signIn.inputUsername();
            case ("password") -> signIn.inputPassword();
        }
    }

    @When("User hovers over Pay Grades")
    public void user_hovers_over_pay_grades() {
        home.findPayGrades();

    }
    @When("User selects Pay Grades")
    public void user_selects_pay_grades() {
        home.clickPayGradesOpt();
    }
    @Then("User go to {string} page")
    public void user_go_to_page(String page) {
        switch (page){
            case "Home" -> home = new HomePage(driver);
            case "PayGrades" -> viewPayGrades = new PayGradesViewPage(driver);
            case "AddPayGrade" -> addNameGrade = new PayGradeAddNamePage(driver);
        }
    }

    @When("User clicks {string}")
    public void user_clicks(String btn) {
        switch (btn) {
            case ("btnAdd") -> viewPayGrades.clickAddBtn();
            case ("btnSave") -> addNameGrade.clickSaveBtn();
            case ("addCurrencyBtn") -> addCurrency.clickAddCurrencyBtn();
            case ("saveCurrencyBtn") -> addCurrency.clickSaveCurrencyBtn();
        }


    }
    @When("User fills {string} field with {string}")
    public void user_fills_field_with(String field, String value) {
        switch (field) {
            case ("minSalary") -> addCurrency.fillMinSalaryField(value);
            case ("maxSalary") -> addCurrency.fillMaxSalaryField(value);
        }
    }
    @When("User adds using {string}")
    public void user_adds_using(String btn) {
        switch (btn) {
            case ("btnAdd") -> viewPayGrades.clickAddBtn();
            case ("addCurrencyBtn") -> addCurrency.clickAddCurrencyBtn();
        }
    }

    @When("User inputs {string} in {string}")
    public void user_inputs_in_field(String value, String field) {
        switch (field) {
            case ("payGradeName") -> {
                addNameGrade.fillNameField(value);
                name = value;
            }
            case ("CurrencyName") -> {
                addCurrency.fillCurrencyNameField(value);
                currency = value.substring(6);
            }
        }
    }

    @When("User saves using {string}")
    public void user_save_using(String btn) {
        switch (btn) {
            case ("btnSave") -> addNameGrade.clickSaveBtn();
            case ("saveCurrencyBtn") -> addCurrency.clickSaveCurrencyBtn();
        }
    }
    @Then("Pay grade is saved")
    public void pay_grade_is_saved() {
        addCurrency = new PayGradeAddCurrencyPage(driver);
        userId = addCurrency.getUserId();
    }
    @Then("Values are saved")
    public void values_are_saved(){
        if (!addCurrency.searchCurrency()) throw new  CucumberException("Currency is not saved");
    }
    @Then("User sees created Pay Grade")
    public void user_sees_created_pay_grade() {
        String[] userData=viewPayGrades.searchUserDataById(userId);
        if (!viewPayGrades.checkUserName(name, userData[1]) || !viewPayGrades.checkCurrency(currency, userData[2])){
            throw new CucumberException("Incorrect saving");
        }

    }

    @When("User ticks created Pay Grade")
    public void user_ticks_created_pay_grade() {
        viewPayGrades.tickPayGradeToDelete(userId);
    }

    @When("User deletes")
    public void user_deletes_using() {
        viewPayGrades.clickDeleteBtn();
    }

    @When("User confirms")
    public void user_confirms() {
        viewPayGrades.confirmDelete();
    }

    @Then("Pay Grade is deleted")
    public void pay_grade_is_deleted() {
        if (!viewPayGrades.checkDeletion(userId)) throw new CucumberException("Pay Grade is not deleted");
    }
}
