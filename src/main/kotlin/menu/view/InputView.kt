package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCoaches(): String {
        val coaches = Console.readLine()
        return coaches
    }
}