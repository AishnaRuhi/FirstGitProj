package pages;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(){
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, LoginPage.class);
    }

    @FindBy(id="Email")
    WebElement txtEmail;

    @FindBy(id="Password")
    WebElement txtPassword;

    //@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    WebElement lnkLogout;

    public void setUserName(String uname){
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setUserPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }
}
