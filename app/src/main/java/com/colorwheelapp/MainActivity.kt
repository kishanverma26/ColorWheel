package com.colorwheelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.colorwheelapp.preview.PreviewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMainFragmentIfNotAttached()
    }

    private fun addMainFragmentIfNotAttached() {
        if (supportFragmentManager.fragments.isEmpty()) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, PreviewFragment())
                .commit()
        }
    }
}
