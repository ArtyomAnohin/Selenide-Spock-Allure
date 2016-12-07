package com.test

import ru.yandex.qatools.allure.annotations.Title
import spock.lang.Specification

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$
import static com.codeborne.selenide.Selenide.open

/**
 * Created by artyom
 */

@Title("Simple Specification")
class SimpleTest extends Specification{
    def "Simple test"(){
        given: "Open URL"
            open("http://computer-database.gatling.io/")
        when: "Search apple computers"
            $("#searchbox").sendKeys("apple")
            $("#searchsubmit").click()
        then: "Result should have 10"
        $$("tbody>tr").shouldHaveSize(11)
    }
}
