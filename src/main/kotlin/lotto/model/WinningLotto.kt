package lotto.model

import lotto.constant.Number
import lotto.constant.Error
class WinningLotto(private val numbers: Lotto, private val bonus: Int) {
    init {
        validateBonusNumber() // numbers 관련은 Lotto에서 처리
    }

    private fun validateBonusNumber() {
        if (bonus !in Number.LOTTO_START..Number.LOTTO_END) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_RANGE)
        }
        if (numbers.getSortedNumbers().contains(bonus)) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.DUPLICATE_NUMBER)
        }
    }

    fun match(userLotto: Lotto): LottoRank {
        val userNumbers = userLotto.getSortedNumbers()

        val matchCount = numbers.getSortedNumbers().intersect(userNumbers.toSet()).size

        val matchBonus = userNumbers.contains(bonus)

        return LottoRank.valueOf(matchCount, matchBonus)

    }
}