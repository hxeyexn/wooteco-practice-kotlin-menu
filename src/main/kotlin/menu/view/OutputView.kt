package menu.view

class OutputView {

    fun printStartService() {
        println("점심 메뉴 추천을 시작합니다.\n")
    }

    fun printRequestInputCoach() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
    }

    fun printError(error: String?) {
        println("\n$error")
    }

    fun printRequestInputNonIntake(name: String) {
        println("\n$name(이)가 못 먹는 메뉴를 입력해 주세요.")
    }

    fun printResultServiceHeadLine() {
        println("\n메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
    }

    fun printCategory(categories: List<String>) {
        println(categories.joinToString(prefix = "[ 카테고리 | ", separator = " | ", postfix =  " ]"))
    }

    fun printRecommendMenu(coachName: String, menus: List<String>) {
        println(menus.joinToString(prefix = "[ $coachName | ", separator = " | ", postfix =  " ]"))
    }

    fun printServiceEnd() {
        print("\n추천을 완료했습니다.")
    }

}