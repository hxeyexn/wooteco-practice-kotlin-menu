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

}