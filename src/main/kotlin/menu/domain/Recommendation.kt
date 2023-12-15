package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.menu.Categories

class Recommendation {

    fun choiceCategory(): List<String>  {
        val categories = mutableListOf<String>()

        do {
            val category = Categories.entries[Randoms.pickNumberInRange(1, 5) - 1].type
            if (categories.filter { it == category }.size < 2) {
                categories.add(category)
            }
        } while (categories.size < 5)

        return categories
    }

}