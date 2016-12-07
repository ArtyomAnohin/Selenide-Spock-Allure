package com.test

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

/**
 * Created by artyom
 */
class GlobalSpecExtension implements IGlobalExtension{
    @Override
    void start() {}

    @Override
    void visitSpec(SpecInfo spec) {
        spec.addListener(new ExampleListener())
    }

    @Override
    void stop() {}
}
