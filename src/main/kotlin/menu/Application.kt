package menu

import menu.view.InputView
import menu.view.OutputView

fun main() {
    val outputView = OutputView()
    val inputView = InputView()

    Service(outputView, inputView).start()
}
