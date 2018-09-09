package tests;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.open;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPageJira;
import pages.SearchPage;

public class RegressionTests {

    private static LoginPageJira loginPage;
    private static SearchPage searchPage;
    private static DashboardPage dashboardPage;

    @BeforeMethod(groups= "LoginRegression")
    public void setUp(){
        loginPage = new LoginPageJira();
        dashboardPage = new DashboardPage();
        searchPage = new SearchPage();
        Configuration.browser = "chrome";
        open("http://jira.hillel.it:8080/login.jsp");
    }

    @Test(groups= "LoginRegression")
    public void logIn(){
        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmitButton();
        loginPage.atRequiredPage();
    }

    @Test(groups= "Regression", dependsOnGroups= {"LoginRegression"})
    public void testValidJQL(){
        logIn();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickAdvancedButtonSelenide();
        searchPage.advancedField("project = QAAUT6 AND text ~ \"Test new issue\" order by lastViewed DESC");
        searchPage.clickSearchButton();
        searchPage.titleTestNewIssue();
    }

    @Test(groups= "Feature", dependsOnGroups= {"LoginRegression"})
    public void testInvalidJQL() {
        logIn();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickAdvancedButtonSelenide();
        searchPage.advancedField("project = QAAUT6 AND text ~ \"Test new issue\" order by lastViewed DEssSC");
        searchPage.clickSearchButton();
        searchPage.errorIcon();
        searchPage.errorMessageTable();
    }



}
