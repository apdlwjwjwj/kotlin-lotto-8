package lotto.controller

import lotto.view.LottoView
import lotto.constant.Error

class LottoController(private val lottoView: LottoView) {

    fun run(){
        val purchaseAmount = getPurchaseAmount()
        lottoView.printCount(purchaseAmount)
    }

    private fun getPurchaseAmount(): Int{
        lottoView.printAmount()
        val input = lottoView.readInput()
        return validateAmount(input)
    }

    fun validateAmount(input: String): Int{
        val amount = input.toIntOrNull()
            ?:throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_NUMBER)

        if (amount%1000 != 0) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_PURCHASE_UNIT)
        }

        return amount/1000
    }
}