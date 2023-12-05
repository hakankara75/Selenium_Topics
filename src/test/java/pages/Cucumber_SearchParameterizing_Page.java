package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.*;
import java.util.List;

public class Cucumber_SearchParameterizing_Page {

    public Cucumber_SearchParameterizing_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath= "//input[@id='pz-form-input-AutocompleteInput']")
    public WebElement searchBox;

    @FindBy (xpath= "//a[@class='product-item__name']")
    public List<WebElement> login;
    @FindBy (xpath= "(//button[@class='action-menu__button -active'])[1]")
    public WebElement english;
    @FindBy (xpath= "//img[@class='mfp-close wis-mfp-close-244800']")
    public WebElement reklam;
    @FindBy (xpath= "//button[@class='cc-nb-reject']")
    public WebElement coocies;
    @FindBy (xpath= " (//img[@src='https://dbfukofby5ycr.cloudfront.net/m13/1/1657/d2304/1f5ba-c--k--s---konu.png'])[1]")
    public WebElement miniReklam;
    @FindBy (xpath= " //div[@class='searched-text']")
    public WebElement sonuc;

}