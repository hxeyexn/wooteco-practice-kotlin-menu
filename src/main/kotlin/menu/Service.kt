package menu

import menu.view.InputView
import menu.view.OutputView

class Service(
    private val outputView: OutputView,
    private val inputView: InputView,
) {

    fun start() {
        outputView.printStartService()
        outputView.printRequestInputCoach()
        inputView.readCoaches()
    }

}