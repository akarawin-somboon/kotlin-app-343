package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Get references to UI elements
        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val backButton = findViewById<Button>(R.id.backButton)

        // Handle Login Button Click
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Here you can validate credentials (you can use shared preferences, a database, etc.)
                // For now, let's assume the login is always successful
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Navigate to UserProfileActivity
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)

                // Optional: Finish the current activity to prevent the user from going back to the login page
                finish()
            }
        }

        // Handle Back Button Click
        backButton.setOnClickListener {
            Toast.makeText(this, "Going back!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
