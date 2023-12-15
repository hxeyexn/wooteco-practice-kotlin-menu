package menu.domain.coach

class Coach(
    val name: String,
) {

    init {
        require(checkNameLength()) { "$ERROR $NAME_LENGTH" }
    }

    private fun checkNameLength(): Boolean {
        return name.length in 2..4
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val NAME_LENGTH = "코치의 이름 최소 2글자, 최대 4글자 이어야 합니다."
    }

}