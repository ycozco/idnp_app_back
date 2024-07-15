package com.example.app_back

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPlay = findViewById<Button>(R.id.play_button)
        val btnPause = findViewById<Button>(R.id.pause_button)
        val btnResume = findViewById<Button>(R.id.resume_button)
        val btnStop = findViewById<Button>(R.id.stop_button)

        btnPlay.setOnClickListener(onClickListenerPlay())
        btnPause.setOnClickListener(onClickListenerPause())
        btnResume.setOnClickListener(onClickListenerResume())
        btnStop.setOnClickListener(onClickListenerStop())
    }

    private fun onClickListenerPlay(): (View) -> Unit = {
        val audioPlayServiceIntent = Intent(applicationContext, AudioPlayService::class.java)
        audioPlayServiceIntent.putExtra(AudioPlayService.FILENAME, "las_meninas.mp3")
        audioPlayServiceIntent.putExtra(AudioPlayService.COMMAND, AudioPlayService.PLAY)
        startService(audioPlayServiceIntent)
    }

    private fun onClickListenerPause(): (View) -> Unit = {
        val audioPlayServiceIntent = Intent(applicationContext, AudioPlayService::class.java)
        audioPlayServiceIntent.putExtra(AudioPlayService.COMMAND, AudioPlayService.PAUSE)
        startService(audioPlayServiceIntent)
    }

    private fun onClickListenerResume(): (View) -> Unit = {
        val audioPlayServiceIntent = Intent(applicationContext, AudioPlayService::class.java)
        audioPlayServiceIntent.putExtra(AudioPlayService.COMMAND, AudioPlayService.RESUME)
        startService(audioPlayServiceIntent)
    }

    private fun onClickListenerStop(): (View) -> Unit = {
        val audioPlayServiceIntent = Intent(applicationContext, AudioPlayService::class.java)
        audioPlayServiceIntent.putExtra(AudioPlayService.COMMAND, AudioPlayService.STOP)
        startService(audioPlayServiceIntent)
    }
}
