package lotto.model

import lotto.constant.Number
enum class LottoRank(
    val matchCount: Int,
    val prize: Long,
    val bonus: Boolean = false
) {
    First(Number.FIRST_MATCH, Number.FIRST_PRIZE),
    Second(Number.SECOND_MATCH, Number.SECOND_PRIZE, true),
    Third(Number.SECOND_MATCH, Number.THIRD_PRIZE),
    Fourth(Number.FOURTH_MATCH, Number.FOURTH_PRIZE),
    Fifth(Number.FIFTH_MATCH, Number.FIFTH_PRIZE),
    Miss(Number.NO_MATCH, Number.NO_PRIZE);

    companion object {
        fun valueOf(matchCount: Int, bonus: Boolean): LottoRank {
            return entries.find { rank ->
                rank.matchCount == matchCount && rank.bonus == bonus
            } ?: entries.find { rank ->
                rank.matchCount == matchCount && !rank.bonus
            } ?: Miss
        }
    }
}