package com.example.app_back
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class AudioPlayService:Service() {
    private lateinit var mediaPlayer:MediaPlayer

    companion object{
        const val FILENAME ="FILENAME"
        const val COMMAND = "COMMAND"
        const val PLAY = "PLAY"
        const val STOP = "STOP"

    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val filename = intent.getStringExtra(FILENAME)
        val command = intent.getStringExtra(COMMAND)

        if (command == PLAY){
                audioPlay(filename)
        }else if(command == STOP){
                audioStop()
        }

        return START_STICKY

    }
    private fun audioPlay(filename:String?){
        if (filename!=null){
            val assetFileDescriptor = assets.openFd(filename)
            mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(
                assetFileDescriptor.fileDescriptor,
                assetFileDescriptor.startOffset,
                assetFileDescriptor.length
            )

            assetFileDescriptor.close()
            mediaPlayer.prepare()
            mediaPlayer.setVolume(1f,1f)
            mediaPlayer.isLooping=false
            mediaPlayer.start()

        }
    }
    private fun audioStop(){
        if(mediaPlayer!=null){
            mediaPlayer.stop()
        }
    }
}