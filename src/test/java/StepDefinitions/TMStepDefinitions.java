package StepDefinitions;

import Pages.*;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;

public class TMStepDefinitions extends CommonDriver {

    LoginPage loginPage = new LoginPage();
    TMPage tmPage = new TMPage();
    HomePage homePage = new HomePage();

    @Before
    public void Setup()
    {
        driver = new ChromeDriver();
    }

    @Given("user logs into turnup portal {string} {string}")
    public void userLogsIntoTurnupPortalHari(String userName, String password) {
        loginPage.LoginActions(driver,userName,password);
    }

    @When("user navigates to TM page")
    public void userNavigatesToTMPage() {
        homePage.GoToTMPage(driver);
    }

    @When("user creates a new TM record {string} {string} {string}")
    public void userCreatesANewTMRecordJanuaryYuvaAutomationTestingYuva(String code, String description, String price) throws InterruptedException {
        try {
            tmPage.createTimeRecord(driver,code,description,price);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("TM record should be saved")
    public void tmRecordShouldBeSaved() {
        tmPage.AssertCreateTMRecord(driver);
    }

    @When("user edits a TM record {string} {string} {string}")
    public void userEditsATMRecordCodeDescriptionPrice(String code, String description, String price) {
        tmPage.editTimeRecord(driver, code, description, price);
    }

    @Then("TM record should be Edited")
    public void tmRecordShouldBeEdited() throws InterruptedException {
        tmPage.AssertEditedTimeRecord(driver);
    }

    @When("user deletes a  TM record")
    public void userDeletesATMRecord() throws InterruptedException {
        tmPage.deleteTimeRecord(driver);
    }

    @Then("TM record should be deleted")
    public void tmRecordShouldBeDeleted() throws InterruptedException {
        tmPage.AssertDeletedTimeRecord(driver);
        //throw new PendingException();
    }

    @After
    public void closeTestRun()
    {
        driver.quit();
    }
}
