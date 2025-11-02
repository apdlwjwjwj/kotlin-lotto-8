package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import lotto.controller.LottoController
import lotto.view.LottoView
import org.assertj.core.api.Assertions.assertThat

class InputTest {

    private val lottoController = LottoController(LottoView())

    @Test
    fun `구매 금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoController.validateAmount("a")
        }
    }

    @Test
    fun `구매 금액이 1000의 배수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoController.validateAmount("100")
        }
    }

    @Test
    fun `정상적인 작동`() {
        val result = lottoController.validateAmount("5000")
        assertThat(result).isEqualTo(5)
    }
}