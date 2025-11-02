package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import lotto.controller.LottoController
import lotto.model.Lotto
import lotto.model.WinningLotto
import lotto.view.LottoView
import org.assertj.core.api.Assertions.assertThat

class BonusNumberTest {
    @Test
    fun `중복된 보너스 번호가 들어오면 예외가 발생한다`() {
        val mainNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 1

        assertThrows<IllegalArgumentException> {
            WinningLotto(mainNumbers, bonusNumber)
        }
    }

    @Test
    fun `범위 외의 번호가 들어오면 예외가 발생한다`() {
        val mainNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 46

        assertThrows<IllegalArgumentException> {
            WinningLotto(mainNumbers, bonusNumber)
        }
    }
}