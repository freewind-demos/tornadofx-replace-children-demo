package example

import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

class HelloWorld : View() {
    private lateinit var mainPanel: Pane
    override val root = vbox {
        hbox {
            button("Replace mainPanel to 'Hello'").setOnAction {
                mainPanel.replaceWith(label("Hello"))
            }
            button("Replace mainPanel to 'World'").setOnAction {
                mainPanel.replaceWith(label("World"))
            }
        }

        pane {
            mainPanel = this
            addClass(HelloWorldStyle.mainPanel)
            label("I'm mainPanel, I have a red border")

            VBox.setVgrow(this, Priority.ALWAYS)
        }
    }
}

class HelloWorldStyle : Stylesheet() {
    companion object {
        val mainPanel by cssclass()
    }

    init {
        root {
            prefWidth = 400.px
            prefHeight = 400.px
        }

        mainPanel {
            borderWidth += box(4.px)
            borderColor += box(Color.RED)
        }
    }
}

class HelloWorldApp : App(HelloWorld::class, HelloWorldStyle::class)

fun main(args: Array<String>) {
    launch<HelloWorldApp>()
}