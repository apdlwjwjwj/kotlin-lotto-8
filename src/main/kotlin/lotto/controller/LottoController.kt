package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.LottoView
import lotto.model.Lotto
import lotto.model.WinningLotto
import lotto.constant.Error
import lotto.constant.Number
import lotto.model.LottoResult

class LottoController(private val lottoView: LottoView) {

    fun run(){
        val purchaseAmount = getPurchaseAmount()
        lottoView.printCount(purchaseAmount)

        val lottos = generateLotto(purchaseAmount)
        lottoView.printLotto(lottos)

        val winningNumber = getWinningLotto()
        val bonusNumber = getBonusNumber()

        val winningLotto = WinningLotto(winningNumber, bonusNumber)

        val result = LottoResult(lottos, winningLotto, purchaseAmount)
        lottoView.printResult(result)

    }

    private fun getPurchaseAmount(): Int{
        lottoView.printAmount()
        val input = lottoView.readInput()
        return validateAmount(input)
    }

    fun validateAmount(input: String): Int{
        val amount = input.toIntOrNull()
            ?: run {
                println(Error.ERROR_PREFIX + Error.INVALID_NUMBER)
                throw IllegalArgumentException()
            }

        if (amount % Number.LOTTO_UNIT != 0) {
            println(Error.ERROR_PREFIX + Error.INVALID_PURCHASE_UNIT)
            throw IllegalArgumentException()
        }

        return amount/Number.LOTTO_UNIT
    }

    fun generateLotto(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(Number.LOTTO_START, Number.LOTTO_END, Number.LOTTO_COUNT)
            Lotto(numbers)
        }
    }

    private fun getWinningLotto(): Lotto {
        lottoView.printRequestNumber()
        val input = lottoView.readInput()
        val numbers = input.split(',')
            .map { it.trim().toIntOrNull() ?: run {
                println(Error.ERROR_PREFIX + Error.INVALID_INPUT)
                throw IllegalArgumentException()
            } }
        return Lotto(numbers)
    }

    private fun getBonusNumber(): Int {
        lottoView.printBonusNumber()
        val input = lottoView.readInput()

        return input.toIntOrNull() ?: run {
            println(Error.ERROR_PREFIX + Error.INVALID_INPUT)
            throw IllegalArgumentException()
        }
    }
}