package com.example.tetsukasuta4x6.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tetsukasuta4x6.utils.Utility
import com.example.tetsukasuta4x6.utils.Utility.formatTime

class CountdownTimerViewModel: ViewModel() {
    private var countDownTimer: CountDownTimer? = null
    private val time = MutableLiveData(Utility.pourInterval.formatTime())
    private val _progress = MutableLiveData(1.00F)
    private val _isPlaying = MutableLiveData(false)


    val timeString: LiveData<String> = time
    val progress: LiveData<Float> = _progress
    val isPlaying: LiveData<Boolean> = _isPlaying

    fun handleCountdownTimer() {
        when (isPlaying.value) {
            true -> pauseTimer()
            false -> startTimer()
        }
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
    }

    private fun startTimer() {
        _isPlaying.value = true
        countDownTimer = object: CountDownTimer(Utility.pourInterval, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progressValue = millisUntilFinished.toFloat() / Utility.pourInterval
                updateTimerScreen(true, millisUntilFinished.formatTime(), progressValue)
            }

            override fun onFinish() {
                pauseTimer()
            }
        }
        countDownTimer?.start()
    }

    private fun updateTimerScreen(
        isPlaying: Boolean,
        text: String,
        progress: Float
    ) {
        _isPlaying.value = isPlaying
        time.value = text
        _progress.value = progress
    }

}