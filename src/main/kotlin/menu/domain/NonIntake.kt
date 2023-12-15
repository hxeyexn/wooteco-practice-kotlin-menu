package menu.domain

class NonIntake(
    private val nonIntake: String,
) {

    init {
        require(checkNumberOfNonIntake()) { "$ERROR $NUMBER_OF_NON_INTAKE"}
    }

    private fun checkNumberOfNonIntake(): Boolean {
        return nonIntake.split(",").size in 0..2
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val NUMBER_OF_NON_INTAKE = "못 먹는 메뉴는 최소 0개, 최대 2개 입력하실 수 있습니다."
    }

}