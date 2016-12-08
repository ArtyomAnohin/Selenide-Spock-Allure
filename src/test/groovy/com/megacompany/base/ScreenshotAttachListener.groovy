package com.megacompany.base

import com.codeborne.selenide.Screenshots
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo
import ru.yandex.qatools.allure.Allure

import ru.yandex.qatools.allure.events.MakeAttachmentEvent


/**
 * Created by artyom
 */
class ScreenshotAttachListener extends AbstractRunListener{
    def void error(ErrorInfo error) {
        makeAttachment(Screenshots.getLastScreenshot(), "image/png")
    }
    private void makeAttachment(File file, String type) {
        Allure.LIFECYCLE.fire(new MakeAttachmentEvent(file.bytes, file.name, type))
    }
}
