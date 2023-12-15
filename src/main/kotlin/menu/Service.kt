package menu

import menu.domain.coach.Coach
import menu.view.InputView
import menu.view.OutputView
import java.lang.IllegalArgumentException

class Service(
    private val outputView: OutputView,
    private val inputView: InputView,
) {

    private var coaches = ""
    fun start() {
        outputView.printStartService()

        outputView.printRequestInputCoach()
        while (true) {
            try {
                coaches = inputView.readCoaches()
                coaches.split(",").forEach { Coach(it) }
                break
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message)
            }
        }
    }

}