package menu

import menu.domain.Recommendation
import menu.domain.coach.Coach
import menu.view.InputView
import menu.view.OutputView

class Service(
    private val outputView: OutputView,
    private val inputView: InputView,
) {

    private val recommendation = Recommendation()

    private var coachesInput = ""
    private lateinit var coaches: List<Coach>
    private var nonIntakeInput = ""
    private var nonIntake = mutableMapOf<String, List<String>>()

    fun start() {
        outputView.printStartService()
        fetchCoachName()
        fetchNonIntake()
        showServiceEnd()
    }

    private fun fetchCoachName() {
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
    }

    private fun fetchNonIntake() {
        coaches.forEach {
            outputView.printRequestInputNonIntake(it.name)

            while (true) {
                try {
                    nonIntakeInput = inputView.readNonIntake()
                    nonIntake[it.name] = nonIntakeInput.split(",")
                    break
                } catch (e: IllegalArgumentException) {
                    outputView.printError(e.message)
                }
            }
        }
    }

    private fun showServiceEnd() {
        outputView.printResultServiceHeadLine()
        val categories = recommendation.choiceCategory()
        outputView.printCategory(categories)

        nonIntake.forEach { (coach, nonIntakeFood) ->
            val recommendMenu = recommendation.choiceMenu(categories, nonIntakeFood)
            outputView.printRecommendMenu(coach, recommendMenu)
        }

        outputView.printServiceEnd()
    }

}