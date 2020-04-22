import com.codeborne.selenide.CollectionCondition

import com.codeborne.selenide.Condition

import com.codeborne.selenide.Selenide

import com.codeborne.selenide.SelenideElement

import org.openqa.selenium.By

import org.openqa.selenium.WebDriver

import org.openqa.selenium.chrome.ChromeDriver

import org.openqa.selenium.support.PageFactory

import org.testng.annotations.BeforeClass

import org.testng.annotations.Test

import pageObjects.HomePage


import java.util.concurrent.TimeUnit

//#####TEST JavaScript language injections

class SomeTest {
    @Test
    fun run() {
        val className = Selenide.executeJavaScript<String>("""
           let x = document.activeElement;
            return x.className;
        """)
    }
}
