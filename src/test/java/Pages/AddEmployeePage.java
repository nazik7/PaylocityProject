package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class AddEmployeePage {

    public AddEmployeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1")
    public WebElement header;
    @FindBy(id = "btnAddEmployee")
    public WebElement addEmployeeButton;
    @FindBy(xpath = "//h4")
    public  WebElement addEmloyeeHeader;
    @FindBy(xpath = "//label[@for='firstname']/..//child::div//input")
    public WebElement firstNameInput;
    @FindBy(xpath = "//label[@for='lastname']/..//child::div//input")
    public WebElement lastNameInput;
    @FindBy(xpath = "//label[@for='dependents']/..//child::div//input")
    public WebElement dependentsInput;
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//tbody//tr[last()]//td")
    public List<WebElement> employeeDetailsLast;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> employeeDetailsFirst;

    @FindBy (xpath = "//tbody//tr[last()]//span[@id='btnEdit']")
    public WebElement editLastButton;

    @FindBy(xpath = "//span[@id=‘btnDelete’]")
    public WebElement deleteButton;

    @FindBy(xpath = "//tbody//tr[last()]//td//span[@id='btnDelete']")
    public WebElement deleteLastEmployeeBtn;

    public List<String> getEmployeeDetails(List<WebElement> employeeDetails){
        List<String> employeeDetails1=new ArrayList<>();
        for (WebElement element : employeeDetails){
            employeeDetails1.add(element.getText());
        }
        return employeeDetails1;
    }


}
