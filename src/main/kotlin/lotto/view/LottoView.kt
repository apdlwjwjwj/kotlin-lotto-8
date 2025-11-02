package lotto.view

import lotto.constant.Message
import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto


class LottoView {

    fun printAmount(){
        println(Message.REQUEST_AMOUNT)
    }

    fun printCount(count: Int){
        println()
        println(Message.COUNT.format(count))
    }

    fun printLotto(lottos: List<Lotto>){
        lottos.forEach { lotto ->
            println(lotto.getSortedNumbers())
        }
    }

    fun printRequestNumber(){
        println()
        println(Message.REQUEST_NUMBER)
    }

    fun printBonusNumber(){
        println()
        println(Message.REQUEST_BONUS_NUMBER)
    }

    fun printErrorMessage(message: String){
        println(message)
    }

    fun readInput(): String{
        return Console.readLine()
    }
}