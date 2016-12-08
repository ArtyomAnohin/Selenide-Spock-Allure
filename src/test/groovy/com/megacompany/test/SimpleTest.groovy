package com.megacompany.test

import com.codeborne.selenide.Condition
import com.megacompany.Pages.AddNewComputerPage
import com.megacompany.Pages.MainPage
import ru.yandex.qatools.allure.annotations.Title
import spock.lang.Specification
import static com.codeborne.selenide.Condition.*

/**
 * Created by artyom
 */

@Title("Simple Specification")
class SimpleTest extends Specification {
    MainPage mainPage = new MainPage()
    AddNewComputerPage addNewComputerPage = new AddNewComputerPage()

    def "Ability to filter computers by name"() {
        given: "Open URL"
        mainPage.openMainPage()
        when: "Enter apple"
        mainPage.filterByName("apple")
        then: "Result table should have 10 rows"
        mainPage.filterResults.shouldHaveSize(11)
    }

    def "Ability to add new computer"() {
        String compName = "Megatron"
        given: "Open URL"
        mainPage.openMainPage()
        and: "Open Add new computer form"
        mainPage.clickAddNewcomputerButton()
        when: "Fill all fields"
        addNewComputerPage.fillAddNewComputerForm(compName, "2016-01-01", "2016-01-05", "Timex Sinclair")
        then: "Accept message should be dislayed"
        mainPage.acceptMessage().shouldHave(Condition.text("Done? Computer " + compName + " has been created"))

    }

}
