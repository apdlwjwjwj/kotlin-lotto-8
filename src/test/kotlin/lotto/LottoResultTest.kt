package lotto

import lotto.model.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    private fun getRank(my: List<Int>): LottoRank {
        val matchCount = my.count { it in winningNumbers }
        val hasBonus = bonusNumber in my
        return LottoRank.valueOf(matchCount, hasBonus)
    }

    @Test
    fun `1등`() {
        val my = listOf(1, 2, 3, 4, 5, 6)
        assertThat(getRank(my)).isEqualTo(LottoRank.First)
    }

    @Test
    fun `2등`() {
        val my = listOf(1, 2, 3, 4, 5, 7)
        assertThat(getRank(my)).isEqualTo(LottoRank.Second)
    }

    @Test
    fun `3등`() {
        val my = listOf(1, 2, 3, 4, 5, 8)
        assertThat(getRank(my)).isEqualTo(LottoRank.Third)
    }

    @Test
    fun `4등`() {
        val my = listOf(1, 2, 3, 4, 10, 11)
        assertThat(getRank(my)).isEqualTo(LottoRank.Fourth)
    }

    @Test
    fun `5등`() {
        val my = listOf(1, 2, 3, 9, 10, 11)
        assertThat(getRank(my)).isEqualTo(LottoRank.Fifth)
    }

    @Test
    fun `낙첨`() {
        val my = listOf(1, 2, 9, 10, 11, 12)
        assertThat(getRank(my)).isEqualTo(LottoRank.Miss)
    }
}
