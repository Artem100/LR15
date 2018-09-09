package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class LoginPageJira {
    public void enterLogin(String login){
        $(By.id("login-form-username")).setValue(login);}

    public void enterPassword(String password){
        $(By.id("login-form-password")).clear();
        $(By.id("login-form-password")).sendKeys(password);}

    public void clickSubmitButton(){
        $(By.id("login-form-submit")).click();
    }

    public boolean atRequiredPage()
    { Assert.assertEquals(title(), "System Dashboard - Hillel IT School JIRA");
        return true;
    }
}
