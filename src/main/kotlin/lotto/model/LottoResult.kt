package lotto.model

import lotto.constant.Number

class LottoResult(
    private val userLottos: List<Lotto>,
    private val winningLotto: WinningLotto,
    private val purchaseAmount: Int
) {
    val statistics: Map<LottoRank, Int>
    val profitRate: Double

    init {
        statistics = calculateStatistics()
        profitRate = calculateProfitRate()
    }

    private fun calculateStatistics(): Map<LottoRank, Int> {
        return userLottos
            .map { lotto -> winningLotto.match(lotto) }
            .groupingBy { rank -> rank }
            .eachCount()
    }

    private fun calculateProfitRate(): Double {
        val totalPrize = statistics.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        return (totalPrize.toDouble() / (purchaseAmount* Number.LOTTO_UNIT)) * 100.0
    }
}