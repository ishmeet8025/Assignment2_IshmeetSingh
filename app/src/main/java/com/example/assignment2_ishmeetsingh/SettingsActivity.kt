package com.example.assignment2_ishmeetsingh

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class SettingsActivity : AppCompatActivity() {
    private val TAG = "SettingsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        Log.d(TAG, "onCreate")

        val themeSwitch = findViewById<Switch>(R.id.switchTheme)
        val sp = getSharedPreferences("settings", MODE_PRIVATE)
        val isDark = sp.getBoolean("dark", false)
        themeSwitch.isChecked = isDark

        themeSwitch.setOnCheckedChangeListener { _: CompoundButton, checked: Boolean ->
            sp.edit().putBoolean("dark", checked).apply()
            // For this simple version we do not dynamically apply the theme.
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG,"onStart") }
}
