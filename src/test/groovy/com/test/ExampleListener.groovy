package com.test

import com.codeborne.selenide.Screenshots
import com.google.common.io.Files
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo
import ru.yandex.qatools.allure.Allure
import ru.yandex.qatools.allure.annotations.Attachment
import ru.yandex.qatools.allure.events.MakeAttachmentEvent

/**
 * Created by artyom
 */
class ExampleListener extends AbstractRunListener{
    def void error(ErrorInfo error) {
        println "Actual on error logic"
        File screenshot = Screenshots.getLastScreenshot()
        makeAttachment(screenshot, "image/png")
    }
    private void makeAttachment(File file, String type) {
        Allure.LIFECYCLE.fire(new MakeAttachmentEvent(file.bytes, file.name, type))
    }
}
