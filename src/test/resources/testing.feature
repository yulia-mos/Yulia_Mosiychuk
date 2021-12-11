@selenium
Feature: opensource-demo.orangehrmlive.com testing
  Scenario Outline: Sign in
    Given User on <pageBefore> page
    When User tabs <username>
    And User tabs <password>
    Then User go to <pageAfter> page
    Examples:
      |pageBefore|username|password|pageAfter|
      |"Authentication"|"username"|"password"|"Home"|

  Scenario Outline: Go to Pay Grades page
    Given User on <pageBefore> page
    When User hovers over Pay Grades
    And User selects Pay Grades
    Then User go to <pageAfter> page
    Examples:
      |pageBefore|pageAfter|
      |"Home" |"PayGrades"|

  Scenario Outline: Add Pay Grade
    Given User on <pageBefore> page
    When User adds using <addBtn>
    And User go to <page> page
    And User inputs <name> in <field>
    And User saves using <btnSave>
    Then Pay grade is saved
    Examples:
      |addBtn|pageBefore|page|name|field|btnSave|
      |"btnAdd"|"PayGrades"|"AddPayGrade"|"Meow~~"|"payGradeName"|"btnSave"|


  Scenario Outline: Add Currency
        Given User on <pageBefore> page
        When User adds using <addBtn>
        And User inputs <currency> in <field>
        And User fills <minSalary> field with <minValue>
        And User fills <maxSalary> field with <maxValue>
        And User saves using <saveBtn>
        Then Values are saved
        Examples:
        |pageBefore|addBtn|currency|field|minSalary|minValue|maxSalary|maxValue|saveBtn|
        |"AddCurrency"|"addCurrencyBtn"|"UAH - Ukraine Hryvnia"|"CurrencyName"|"minSalary"|"4000"|"maxSalary"|"8000"|"saveCurrencyBtn"|

        Scenario Outline: Checking input data
          Given User on <pageBefore> page
          When User hovers over Pay Grades
          And User selects Pay Grades
          Then User go to <pageAfter> page
          And User sees created Pay Grade
          Examples:
            |pageBefore|pageAfter|
            |"Home" |"PayGrades" |

        Scenario Outline: Delete Pay Grade
          Given User on <pageBefore> page
          When User ticks created Pay Grade
          And User deletes
          And User confirms
          Then Pay Grade is deleted
          Examples:
          |pageBefore|
          |"PayGrades"|

