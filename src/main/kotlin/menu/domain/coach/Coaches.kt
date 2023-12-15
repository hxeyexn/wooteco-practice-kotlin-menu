package menu.domain.coach

class Coaches(
    private val coaches: String,
) {

    init {
        require(checkNumberOfCoaches()) { "$ERROR $NUMBER_OF_COACHES" }
    }

    private fun checkNumberOfCoaches(): Boolean {
        return coaches.split(",").size in 2..5
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val NUMBER_OF_COACHES = "코치 수는 최소 2명, 최대 5명 입력하실 수 있습니다."
    }

}