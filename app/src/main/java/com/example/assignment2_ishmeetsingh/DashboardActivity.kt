package com.example.assignment2_ishmeetsingh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    private val TAG = "DashboardActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        logLifecycle("onCreate")

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnCountries = findViewById<Button>(R.id.btnCountries)
        val btnSettings = findViewById<Button>(R.id.btnSettings)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val name = Prefs.getFullName(this) ?: Prefs.getEmail(this) ?: "User"
        tvWelcome.text = "Welcome, $name"

        btnProfile.setOnClickListener { startActivity(Intent(this, ProfileActivity::class.java)) }
        btnCountries.setOnClickListener { startActivity(Intent(this, CountriesListActivity::class.java)) }
        btnSettings.setOnClickListener { startActivity(Intent(this, SettingsActivity::class.java)) }

        btnLogout.setOnClickListener {
            Prefs.clearAll(this)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun logLifecycle(m: String) = Log.d(TAG, m)
    override fun onStart(){ super.onStart(); logLifecycle("onStart") }
    override fun onResume(){ super.onResume(); logLifecycle("onResume") }
    override fun onPause(){ super.onPause(); logLifecycle("onPause") }
    override fun onStop(){ super.onStop(); logLifecycle("onStop") }
    override fun onDestroy(){ super.onDestroy(); logLifecycle("onDestroy") }
}
