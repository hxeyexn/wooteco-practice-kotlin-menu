package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.NonIntake
import menu.domain.coach.Coaches

class InputView {

    fun readCoaches(): String {
        val coaches = Console.readLine()
        Coaches(coaches)
        return coaches
    }

    fun readNonIntake(): String {
        val nonIntake = Console.readLine()
        NonIntake(nonIntake)
        return nonIntake
    }
}