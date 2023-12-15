package menu

import menu.domain.coach.Coach
import menu.view.InputView
import menu.view.OutputView
import kotlin.IllegalArgumentException

class Service(
    private val outputView: OutputView,
    private val inputView: InputView,
) {

    private var coachesInput = ""
    private lateinit var coaches: List<Coach>

    fun start() {
        outputView.printStartService()

        outputView.printRequestInputCoach()

        while (true) {
            try {
                coachesInput = inputView.readCoaches()
                coaches = coachesInput.split(",").map { Coach(it) }
                break
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message)
            }
        }

        coaches.forEach {
            outputView.printRequestInputNonIntake(it.name)

            while (true) {
                try {
                    inputView.readNonIntake()
                    break
                } catch (e: IllegalArgumentException) {
                    outputView.printError(e.message)
                }
            }
        }

    }

}