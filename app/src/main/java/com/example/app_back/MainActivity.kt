package com.example.app_back

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.example.app_back.ui.theme.App_backTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {
            v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }

        val btnPlay = findViewById<Button>(R.id.play_button)
        val btnStop = findViewById<Button>(R.id.stop_button)

        btnPlay.setOnClickListener(onClickListenerPlay())
        btnStop.setOnClickListener(onClickListenerStop())
    }
    private fun onClickListenerPlay():(View)->Unit={
    val audioPlayServiceIntent = Intent(applicationContext,AudioPlayService::class.java)
        audioPlayServiceIntent.putExtra(AudioPlayService.FILENAME,"musica.mp3")
        audioPlayServiceIntent.putExtra(AudioPlayService.COMMAND,AudioPlayService.PLAY)
        startService(audioPlayServiceIntent)

    }
    private fun onClickListenerStop():(View)->Unit= {
        val audioPlayServiceIntent = Intent(applicationContext,AudioPlayService::class.java)
        audioPlayServiceIntent.putExtra(AudioPlayService.COMMAND,AudioPlayService.STOP)
        startService(audioPlayServiceIntent)
    }
}

