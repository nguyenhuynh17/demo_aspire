package pages.objects;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageObjects {
    private WebDriver driver;
    public BasePage basePage;
    //Locators
    @FindBy(xpath = "//input[@id='login']")
    private WebElement EmailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement PasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement LoginBtn;

    @FindBy(xpath = "//div[text()='Discuss']")
    private WebElement discussLbl;

    //Constructor
    public LoginPageObjects(WebDriver driver){
        this.driver=driver;
        basePage = new BasePage(this.driver);

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void assertDiscussLblIsDisplayed(){
       basePage.waitVisibility(discussLbl);
    }

    public void clickOnLoginButton(){
        LoginBtn.submit();
    }

    public void inputEmailField(String text){
        basePage.writeText(EmailField,text);
    }

    public void inputPasswordField(String text){
        basePage.writeText(PasswordField,text);
    }
}
