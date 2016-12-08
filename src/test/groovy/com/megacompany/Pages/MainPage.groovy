package com.megacompany.Pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import ru.yandex.qatools.allure.annotations.Step

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$
import static com.codeborne.selenide.Selenide.open

/**
 * Created by artyom
 */
class MainPage{
    @Step
    def openMainPage(){
        open("http://computer-database.gatling.io/")
    }

    ElementsCollection filterByName(String name){
        $("#searchbox").val(name)
        $("#searchsubmit").click()
        return getFilterResults()
    }
    ElementsCollection getFilterResults() {
        return $$(By.xpath(".//tbody/tr/td[1]"))
    }
    @Step
    def clickAddNewcomputerButton(){
        $("#add").click()
    }
    @Step
    def acceptMessage(){
        return $(".alert-message")
    }
}
