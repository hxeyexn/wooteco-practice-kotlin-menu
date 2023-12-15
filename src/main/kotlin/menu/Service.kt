package menu

import menu.view.OutputView

class Service(
    private val outputView: OutputView
) {

    fun start() {
        outputView.printStartService()
        outputView.printRequestInputCoach()
    }

}