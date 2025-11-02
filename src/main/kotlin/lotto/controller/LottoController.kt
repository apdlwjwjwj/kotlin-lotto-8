package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.LottoView
import lotto.model.Lotto
import lotto.constant.Error
import lotto.constant.Number

class LottoController(private val lottoView: LottoView) {

    fun run(){
        val purchaseAmount = getPurchaseAmount()
        lottoView.printCount(purchaseAmount)

        val lottos = generateLotto(purchaseAmount)
        lottoView.printLotto(lottos)
    }

    private fun getPurchaseAmount(): Int{
        lottoView.printAmount()
        val input = lottoView.readInput()
        return validateAmount(input)
    }

    fun validateAmount(input: String): Int{
        val amount = input.toIntOrNull()
            ?:throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_NUMBER)

        if (amount%Number.LOTTO_UNIT != 0) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_PURCHASE_UNIT)
        }

        return amount/Number.LOTTO_UNIT
    }

    fun generateLotto(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(Number.LOTTO_START, Number.LOTTO_END, Number.LOTTO_COUNT)
            Lotto(numbers)
        }
    }
}