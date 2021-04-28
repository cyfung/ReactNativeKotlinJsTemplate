@file:JsModule("react-native")
@file:JsNonModule

package com.kumatheta.react.native

import react.RClass
import react.RProps

external interface ViewProps : RProps {
    var style: dynamic
}

external interface TextProps : RProps {
}

@JsName("View")
external val view: RClass<ViewProps>

@JsName("Text")
external val text: RClass<TextProps>
