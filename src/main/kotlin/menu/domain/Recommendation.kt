package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.menu.Categories

class Recommendation {

    private lateinit var menus: List<String>

    fun choiceCategory(): List<String> {
        val categories = mutableListOf<String>()

        do {
            val category = Categories.entries[Randoms.pickNumberInRange(1, 5) - 1].type
            if (categories.filter { it == category }.size < 2) {
                categories.add(category)
            }
        } while (categories.size < 5)

        return categories
    }

    fun choiceMenu(categories: List<String>, nonIntake: List<String>): List<String> {
        val categoriesType = Categories.entries.map { it.type }
        val choiceMenus = mutableListOf<String>()

        categories.forEach { category ->
            menus = when (category) {
                categoriesType[JAPANESE_TYPE] -> Categories.JAPANESE.menu.map { it }
                categoriesType[KOREAN_TYPE] -> Categories.KOREAN.menu.map { it }
                categoriesType[CHINESE_TYPE] -> Categories.CHINESE.menu.map { it }
                categoriesType[ASIAN_TYPE] -> Categories.ASIAN.menu.map { it }
                categoriesType[WESTERN_TYPE] -> Categories.WESTERN.menu.map { it }
                else -> listOf("")
            }
            val menu = Randoms.shuffle(menus)[0]

            if (!nonIntake.contains(menu) || !choiceMenus.contains(menu)) {
                choiceMenus.add(menu)
            }
        }

        return choiceMenus
    }

    companion object {
        const val JAPANESE_TYPE = 0
        const val KOREAN_TYPE = 1
        const val CHINESE_TYPE = 2
        const val ASIAN_TYPE = 3
        const val WESTERN_TYPE = 4
    }

}