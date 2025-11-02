package lotto.model

import lotto.constant.Error
import lotto.constant.Number

class Lotto(private val numbers: List<Int>) {
    init {
        validateSize()
        validateDuplicate()
        validateRange()
    }

    private fun validateSize() {
        if (numbers.size != Number.LOTTO_COUNT) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_SIZE)
        }
    }

    private fun validateDuplicate() {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.DUPLICATE_NUMBER)
        }
    }

    private fun validateRange() {
        if (numbers.any { it !in Number.LOTTO_START..Number.LOTTO_END }) {
            throw IllegalArgumentException(Error.ERROR_PREFIX + Error.INVALID_RANGE)
        }
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }
}