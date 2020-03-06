package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "form-username")
    public WebElement usernameInput;

    @FindBy(name = "form-password")
    public WebElement passwordInput;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;


    @FindBy(id = "validation-errors")
    public WebElement errorMessage;
}
