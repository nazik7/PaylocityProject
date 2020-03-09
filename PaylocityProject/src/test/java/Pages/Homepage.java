package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1")
    public WebElement header;
    @FindBy(xpath = "//table[@id='employee-table']//th")
    public List<WebElement> tableHeaders;

    public static List<String> getTextList(List<WebElement> elements){
        List<String> textList=new ArrayList<>();
        for(WebElement element:elements){
            textList.add(element.getText());
        }
        return textList;
    }
}
