package com.example.assignment2_ishmeetsingh

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    private val TAG = "RegistrationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        Log.d(TAG, "onCreate")

        val etName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etProgram = findViewById<EditText>(R.id.etProgram)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val ageStr = etAge.text.toString().trim()
            val program = etProgram.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || ageStr.isEmpty() || program.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show(); return@setOnClickListener
            }
            val age = ageStr.toIntOrNull()
            if (age == null || age <= 0) {
                etAge.error = "Enter valid age"; return@setOnClickListener
            }

            Prefs.saveProfile(this, name, email, age, program)
            Toast.makeText(this, "Registered. Please login.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG,"onStart") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG,"onDestroy") }
}
