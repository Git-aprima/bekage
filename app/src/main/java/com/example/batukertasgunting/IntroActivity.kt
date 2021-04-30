@file:Suppress("SyntaxError", "PrivatePropertyName")

package com.example.batukertasgunting

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("ParcelCreator")
class IntroActivity : AppCompatActivity() {

    private val SPLASH_TIME: Long = 3000
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        mediaPlayer = MediaPlayer.create(this, R.raw.intro)
        mediaPlayer.start()
        Log.d("SPLASH SCREEN", "SPLASH SCREEN")
        mediaPlayer.setOnCompletionListener {
            val intent = Intent(this, MainActivity::class.java)
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                mediaPlayer.stop()
            }, SPLASH_TIME)
        }
    }
}