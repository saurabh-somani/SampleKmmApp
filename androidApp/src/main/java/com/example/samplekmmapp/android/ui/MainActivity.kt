package com.example.samplekmmapp.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.samplekmmapp.android.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchFragment(savedInstanceState)
    }

    private fun launchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }
    }
}
