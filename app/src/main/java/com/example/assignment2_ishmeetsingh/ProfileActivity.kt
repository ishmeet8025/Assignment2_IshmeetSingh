package com.example.assignment2_ishmeetsingh

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAge: TextView
    private lateinit var tvProgram: TextView
    private lateinit var btnEditProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize Views
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvAge = findViewById(R.id.tvAge)
        tvProgram = findViewById(R.id.tvProgram)
        btnEditProfile = findViewById(R.id.btnEditProfile)

        loadUserData()

        btnEditProfile.setOnClickListener {
            showEditProfileDialog()
        }
    }

    private fun loadUserData() {
        val sp = getSharedPreferences("user_data", Context.MODE_PRIVATE)

        tvName.text = sp.getString("name", "N/A")
        tvEmail.text = sp.getString("email", "N/A")
        tvAge.text = sp.getInt("age", 0).toString()
        tvProgram.text = sp.getString("program", "N/A")
    }

    private fun showEditProfileDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_profile, null)

        val etEditName = dialogView.findViewById<EditText>(R.id.etEditName)
        val etEditEmail = dialogView.findViewById<EditText>(R.id.etEditEmail)
        val etEditAge = dialogView.findViewById<EditText>(R.id.etEditAge)
        val etEditProgram = dialogView.findViewById<EditText>(R.id.etEditProgram)

        val sp = getSharedPreferences("user_data", Context.MODE_PRIVATE)

        // Prefill current values
        etEditName.setText(sp.getString("name", ""))
        etEditEmail.setText(sp.getString("email", ""))
        etEditAge.setText(sp.getInt("age", 0).toString())
        etEditProgram.setText(sp.getString("program", ""))

        // Show dialog
        AlertDialog.Builder(this)
            .setTitle("Edit Profile")
            .setView(dialogView)
            .setPositiveButton("Save") { _, _ ->
                val name = etEditName.text.toString()
                val email = etEditEmail.text.toString()
                val age = etEditAge.text.toString().toIntOrNull() ?: 0
                val program = etEditProgram.text.toString()

                val editor = sp.edit()
                editor.putString("name", name)
                editor.putString("email", email)
                editor.putInt("age", age)
                editor.putString("program", program)
                editor.apply()

                loadUserData()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
