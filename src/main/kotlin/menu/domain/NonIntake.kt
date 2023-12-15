package menu.domain

import menu.domain.menu.MenuCategory

class NonIntake(
    private val nonIntake: String,
) {

    init {
        require(checkNumberOfNonIntake()) { "$ERROR $NUMBER_OF_NON_INTAKE"}
        require(haveMenu()) { "$ERROR $NON_EXISTENT_MENU"}
    }

    private fun checkNumberOfNonIntake(): Boolean {
        return nonIntake.split(",").size in 0..2
    }

    private fun haveMenu(): Boolean {
        val menu = mutableListOf<String>()
        MenuCategory.JAPANESE.menu.map { menu.add(it) }
        MenuCategory.ASIAN.menu.map { menu.add(it) }
        MenuCategory.CHINESE.menu.map { menu.add(it) }
        MenuCategory.KOREAN.menu.map { menu.add(it) }
        MenuCategory.WESTERN.menu.map { menu.add(it) }

        return nonIntake.split(",").all {
            menu.contains(it)
        }
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val NUMBER_OF_NON_INTAKE = "못 먹는 메뉴는 최소 0개, 최대 2개 입력하실 수 있습니다."
        const val NON_EXISTENT_MENU = "존재하지 않는 메뉴가 포함되어 있습니다."
    }

}