package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public void clickIssueButton() {
        $(By.id("find_link")).click();
    }

    public void clickSearchOfIssues() {
        $("#issues_new_search_link_lnk").click();
    }

    public void clickCreateIssueButton() {
        $(By.id("create_link")).click();
    }

    public void dashboardPage(){
        $(".aui-page-header-main").shouldHave(visible, text("System Dashboard"));
    }

    public void clickHelpMenu()
    {$(By.id("system-help-menu")).shouldBe(visible).click();}

    public void clickJiraCoreHelp()
    {$(By.id("view_core_help")).shouldBe(visible).click();}

    public void jiraCoreHelpPage(){
        $("a.cac-header-logo.logo").shouldHave(visible, text("Jira Core Support"));
    }
}
