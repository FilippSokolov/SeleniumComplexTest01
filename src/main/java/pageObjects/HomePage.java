package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    //#####TEST XPath and CSS language injections everywhere for supported libraries

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    //#####TEST XPath and CSS language injections everywhere for supported libraries

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "/html/body/header/div/nav/ul[2]/li/div/form/div/div[2]/div/input")
    private WebElement passwordFullXpath;

    @FindBy(css = "#login-button")
    private WebElement submit;

    @FindBy(tagName = "a")
    private WebElement findTag;

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

}
