package com.example.movementapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class thresholdViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    var threshold: Double
        get() = savedStateHandle.get<Double>("threshold") ?: 5.0
        set(value) {
            savedStateHandle.set("threshold", value)
        }

}