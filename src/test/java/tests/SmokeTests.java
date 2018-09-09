package tests;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPageJira;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;

public class SmokeTests {

    private static LoginPageJira loginPage;
    private static SearchPage searchPage;
    private static DashboardPage dashboardPage;

    @BeforeMethod(groups= "LoginSmoke")
    public void setUp(){
        loginPage = new LoginPageJira();
        dashboardPage = new DashboardPage();
        searchPage = new SearchPage();
        Configuration.browser = "chrome";
        open("http://jira.hillel.it:8080/login.jsp");
    }

    @Test(groups= "LoginSmoke")
    public void logIn(){
        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmitButton();
        loginPage.atRequiredPage();
    }

    @Test(groups= "smoke")
    public void uncheckTheBoxes(){
        logIn();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickSearchProjectButton();
        searchPage.selectProjectQAAUTO6("QAAUTO-6");
        searchPage.clickFiterTypeIssue();
        searchPage.selectEpicFilter();
        searchPage.clickSomePlace();
        searchPage.clickFiterTypeIssue();
        searchPage.selectEpicFilter();
        searchPage.uncheckSearchProjectFindProjects();
        searchPage.defaultLabelsStatuses();
    }


    @Test(groups= "smoke")
    public void epmtyResultsIssue() {
        logIn();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickAdvancedButtonSelenide();
        searchPage.advancedField("project = QAAUT6 AND issuetype = Task AND status = \"In Progress\" AND creator in (currentUser())");
        searchPage.clickSearchButton();
        searchPage.iconEpmtyResults();
    }


}
