package ch.seleniumConsulting.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPo {

    @FindBy(name = "q")
    private WebElement searchFieldInput;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='rso']/div")
    private List<WebElement> resultList;

    public GoogleSearchPo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchPo enterSearchFieldInput(CharSequence... input){
        this.searchFieldInput.sendKeys(input);
        return this;
    }

    public String getValueOfSearchFieldInput(){
        return this.searchFieldInput.getAttribute("value");
    }

    public GoogleSearchPo clickSearchButton(){
        this.searchButton.click();
        return this;
    }

}


