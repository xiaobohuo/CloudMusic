package com.dom.cloudmusic.feature.splash

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SplashViewModel : ViewModel() {
    private val _timeLeft = MutableStateFlow(0L)
    val timeLeft: StateFlow<Long> = _timeLeft
    private var timer: CountDownTimer? = null
    val navigateToMain = MutableStateFlow(false)

    init {
        delayToNext()
    }

    private fun delayToNext(time: Long = 3000) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timeLeft.value = millisUntilFinished / 1000 + 1
            }

            override fun onFinish() {
                toNext()
            }

        }.start()
    }

    private fun toNext() {
        navigateToMain.value = true
    }

    fun onSkipAdClick() {
        timer?.cancel()
        toNext()
    }
}