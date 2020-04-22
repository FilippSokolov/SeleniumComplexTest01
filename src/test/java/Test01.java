import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Html.text;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.System.setProperty;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertEquals;

public class Test01 {


    //#####TEST - Find usages and completion for @Feature, @Epic, @Story, @Owner and @Lead usages in code for Allure Framework

    @Feature("feature1")
    @Lead("dd")
    @Owner("me")
    @BeforeClass
    @Step
    @Story("Test verify base Test1")
    public void beforeClass() {
        System.setProperty("allure.results.directory", "path/to/directory");
        //   setProperty("webdriver.chrome.driver", "src\main\\resources\\chromedriver.exe");

        System.setProperty("allure.link.mylink.pattern", "https://example.org/mylink/{}");
        System.setProperty("allure.link.issue.pattern", "https://youtrack.jetbrains.com/issue/{}");
        System.setProperty("allure.link.tms.pattern", "https://example.org/tms/{}");

    }

    //#####TEST - Line markers with quick navigation to @Step usages in code for Allure and Serenity BDD (groups step usages by methods in popup)

    @Epic("epic")
    @Step
    @Story("Test verify base Test1")
    public void some() {

    }

    //#####TEST - Line markers with navigation to issues and TMS cases in web browser for Allure and Serenity BDD

    @Issue("IDEA-234005")
    @Test
    public void action1() {

        WebDriver driver = new ChromeDriver();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
//        String hadle = driver.getWindowHandle();
//        driver.switchTo().window(hadle);

        beforeClass();
        some();

        driver.navigate().to("http://epam.github.io/JDI/index.html");

        assertEquals(driver.getTitle(), "Home Page");

        //#####TEST - Code completion for HTML attributes, HTML tag names and CSS properties

        $(tagName("img")).getAttribute("!!COMPLETION");

        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();
        driver.findElement(By.xpath("//*[@id='search-results']//a[contains(text(),'selenide.org')]")).click();

        homePage.login("epam", "1234");

        assertEquals("https://epam.github.io/JDI/", driver.findElement(By.xpath(".//main//h3[@class='text-center']/a"))
                .getAttribute("href"));

        driver.close();

    }

}
