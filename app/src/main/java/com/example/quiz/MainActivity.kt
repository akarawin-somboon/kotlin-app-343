package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val usernameField = findViewById<EditText>(R.id.username)
        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        val confirmPasswordField = findViewById<EditText>(R.id.confirmPassword)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val backButton = findViewById<Button>(R.id.backButton)

        // Handle Sign-Up Button Click
        signUpButton.setOnClickListener {
            val username = usernameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val confirmPassword = confirmPasswordField.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Show success message
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()

                // Navigate to LoginActivity after sign-up
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                // Optional: Finish the current activity to prevent the user from going back to the sign-up page
                finish()
            }
        }

        // Handle Back Button Click
        backButton.setOnClickListener {
            Toast.makeText(this, "Going back!", Toast.LENGTH_SHORT).show()
            // Example: Finish current activity or navigate to a different activity
            finish()
        }
    }
}
