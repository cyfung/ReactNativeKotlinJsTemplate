import com.kumatheta.react.native.text
import com.kumatheta.react.native.view
import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

@JsExport
class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        view {
            attrs.style = jsObject {
                flex = 1
                alignItems = "center"
                justifyContent = "center"
            }
            text {
                +"Hello, World"
            }
        }
    }
}