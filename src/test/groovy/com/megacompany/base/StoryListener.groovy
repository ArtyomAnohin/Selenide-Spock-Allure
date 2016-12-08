package com.megacompany.base

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.BlockInfo
import org.spockframework.runtime.model.FeatureInfo
import ru.yandex.qatools.allure.Allure
import ru.yandex.qatools.allure.events.AddParameterEvent

/**
 * Created by artyom
 */
class StoryListener extends AbstractRunListener {

    void afterFeature(FeatureInfo feature) {
        for ( BlockInfo block : feature.getBlocks() ) {
            Allure.LIFECYCLE.fire(new AddParameterEvent(block.getKind().name(),block.getTexts().toString()))
        }
    }
}
