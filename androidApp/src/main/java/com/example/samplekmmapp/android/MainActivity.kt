package com.example.samplekmmapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.samplekmmapp.Greeting
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.samplekmmapp.network.KtorUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        getMarsProperties(tv)
    }

    private fun greet(): String {
        return Greeting().greeting()
    }

    private fun getMarsProperties(tv: TextView) {
        lifecycleScope.launchWhenStarted {
            val marsProperties = KtorUtil.getMarsPropertiesString()
            tv.text = marsProperties
        }
    }
}
