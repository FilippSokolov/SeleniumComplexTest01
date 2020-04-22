import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.WebDriverWait

import static org.openqa.selenium.support.ui.ExpectedConditions.*

def browser = new FirefoxDriver()
browser.manage().window().maximize()
browser.get('http://translate.google.com/')
def wait = new WebDriverWait(browser, 10)

def languageButton = browser.findElementById('gt-sl-gms')
languageButton.click()

//#####TEST XPath and CSS language completion

def norwegianLanguageLinkLocator = By.xpath("//div[text()='Norwegian']")
wait.until(elementToBeClickable(norwegianLanguageLinkLocator))
browser.findElement(norwegianLanguageLinkLocator).click()

println languageButton.text

browser.findElementById('source').sendKeys('ost')

//#####TEST XPath and CSS language completion

def resultTextBoxLocator = By.cssSelector('#result_box span')
//wait.until(presenceOfElementLocated(resultTextBoxLocator))
wait.until(not(textToBePresentInElement(resultTextBoxLocator, '')))

def result_box = browser.findElement(resultTextBoxLocator)
println "Result text: \"${result_box.text}\""
browser.quit()