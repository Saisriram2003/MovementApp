package com.example.movementapp
import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test

class thresholdViewModelTest{

    private val savedStateHandle = SavedStateHandle()
    @Test
    fun providesExpectedQuestionText() {
        val thresholdViewModel = thresholdViewModel(savedStateHandle)
        val defaultVal = 5.0
        savedStateHandle["threshold"] = null
        val thresholdValue = thresholdViewModel.threshold
        assert(thresholdValue == defaultVal)
    }
    @Test
    fun setThreshold() {
        val thresholdViewModel = thresholdViewModel(savedStateHandle)
        savedStateHandle["threshold"] = 5.0
        val thresholdValue = thresholdViewModel.threshold
        assert(thresholdValue == 5.0)
    }
}

