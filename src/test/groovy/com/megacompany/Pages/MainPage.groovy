package com.megacompany.Pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
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
    @Step
    ElementsCollection filterByName(String name){
        $("#searchbox").val(name)
        $("#searchsubmit").click()
    }
    @Step
    ElementsCollection getNameFilterResults() {
        return $$(By.xpath(".//tbody/tr/td[1]/a"))
    }
    @Step
    ElementsCollection getCompanyFilterResults() {
        return $$(By.xpath(".//tbody/tr/td[4]"))
    }
    @Step
    def clickAddNewComputerButton(){
        $("#add").click()
    }
    @Step("Should have text: {0}")
    def acceptMessage(String text){
        return $(".alert-message").shouldHave(Condition.text(text))
    }
    @Step
    def removeComputer(String name){
        filterByName(name)
        getNameFilterResults().first().click()
        $(".btn.danger").click()
        acceptMessage("Done! Computer has been deleted")
    }
}
