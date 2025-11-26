package com.example.assignment2_ishmeetsingh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        Prefs.getEmail(this)?.let { etEmail.setText(it) }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val pw = etPassword.text.toString()

            if (!email.contains("@")) {
                etEmail.error = "Enter valid email"; return@setOnClickListener
            }
            if (pw.length < 4) {
                etPassword.error = "Password must be at least 4 chars"; return@setOnClickListener
            }

            Prefs.saveLoginEmail(this, email)
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG,"onStart") }
    override fun onResume() { super.onResume(); Log.d(TAG,"onResume") }
    override fun onPause() { super.onPause(); Log.d(TAG,"onPause") }
    override fun onStop() { super.onStop(); Log.d(TAG,"onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG,"onDestroy") }
}
