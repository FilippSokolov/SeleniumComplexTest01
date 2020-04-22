import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.impl.Html.text
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.By
import org.testng.annotations.TestInstance


class TestJunitKotlin {

    @BeforeClass fun setUp() {
        Configuration.startMaximized = false
        open("https://google.com/ncr")
    }

    @Test
    fun usingDollarsWithBackticks() {
        `$`(By.name("q")).setValue("selenide").pressEnter()
        `$$`("#res .g").shouldHave(sizeGreaterThan(5))
//        `$`("#res .g").shouldHave(text("concise ui tests in Java"))
        `$`("#res .g").shouldHave(Condition.exist)
        `$`("#res .g").shouldHave(Condition.text("sdf"))
        `$`("#res .g").shouldNotBe()

        //#####TEST - Code completion for HTML attributes, HTML tag names and CSS properties

        `$$x`("//div").shouldBe(Condition.cssValue("border-bottom-width", "10px"))



        `$`("#res .g").shouldNotBe(Condition.cssValue("border-bottom-color","10px"))





//        $x("//div").shouldBe(Condition.cssValue("border-bottom-width", "10px"));
//        $x("//div").shouldNotBe(Condition.cssValue("border-bottom-width", "10px"));

    }

    @Test fun notUsingDollars() {
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("#res .g")).shouldHave(sizeGreaterThan(5))
  //      element(By.cssSelector("#res .g")).shouldHave(text("concise ui tests in Java"))
    }

    @Test fun usingAliases() {
        get("[name=q]").setValue("selenide").pressEnter()
        get(title());

        all("#res .g").shouldHave(sizeGreaterThan(5))
    //    get("#res .g").shouldHave(text("concise ui tests in Java"))
    }

    fun get(selector: String) : SelenideElement {
        return `$`(selector)
    }

    fun all(selector: String) : ElementsCollection {
        return `$$`(selector)
    }
}

private fun ElementsCollection.shouldBe(cssValue: Condition?) {

}
