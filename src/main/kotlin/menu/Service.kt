package menu

import menu.view.InputView
import menu.view.OutputView
import java.lang.IllegalArgumentException

class Service(
    private val outputView: OutputView,
    private val inputView: InputView,
) {

    fun start() {
        outputView.printStartService()

        outputView.printRequestInputCoach()
        while (true) {
            try {
                inputView.readCoaches()
                break
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message)
            }
        }
    }

}