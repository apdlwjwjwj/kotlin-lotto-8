package lotto

import lotto.controller.LottoController
import lotto.view.LottoView

fun main() {
    val lottoView = LottoView()
    val lottoController = LottoController(lottoView)
}
