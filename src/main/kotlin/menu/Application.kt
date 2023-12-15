package menu

import menu.view.OutputView

fun main() {
    val outputView = OutputView()

    Service(outputView).start()
}
