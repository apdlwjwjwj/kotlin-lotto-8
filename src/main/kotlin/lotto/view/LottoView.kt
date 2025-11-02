package lotto.view

import lotto.constant.Message
import camp.nextstep.edu.missionutils.Console


class LottoView {

    fun printError(message: String){
        println(message)
    }

    fun printAmount(){
        println(Message.REQUEST_AMOUNT)
    }

    fun printCount(count: Int){
        println()
        println(Message.COUNT.format(count))
    }

    fun readInput(): String{
        return Console.readLine()
    }
}