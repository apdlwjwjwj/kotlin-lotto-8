package lotto.view

import lotto.constant.Message
import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoResult


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

    fun printResult(result: LottoResult) {
        println()
        println(Message.WINNING_STATUS)

        val ranksToDisplay = LottoRank.entries
            .filter { it != LottoRank.Miss }
            .sortedBy { it.prize }

        ranksToDisplay.forEach { rank ->
            val count = result.statistics.getOrDefault(rank, 0)
            val format = if (rank.bonus) {
                Message.SECOND_STATUS
            } else {
                Message.STATUS
            }
            println(String.format(format, rank.matchCount, rank.prize, count))
        }

        println(String.format(Message.PROFIT, result.profitRate))
    }

    fun readInput(): String{
        return Console.readLine()
    }
}