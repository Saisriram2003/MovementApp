package com.example.movementapp

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.viewModels
import com.example.movementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    private lateinit var binding: ActivityMainBinding
    val viewModel: thresholdViewModel by viewModels()
    lateinit var sensitivySlider : SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensitivySlider = binding.sensitivitySeekBar

        sensitivySlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    viewModel.threshold = progress.toDouble()
                    binding.sensitivityTextView.text = "Sensitivity: ${progress}"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    // Do nothing
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    // Do nothing
                }
        })

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]


        if (x > viewModel.threshold || (y - 9.8) > viewModel.threshold || z > viewModel.threshold) {
            // Have to log it
            print("Significant movement detected")
            Toast.makeText(this,"Significant movement detected", Toast.LENGTH_SHORT).show()
        }
        binding.accelerometer.text = "X: ${x}\nY: ${y}\nZ: ${z}"

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}