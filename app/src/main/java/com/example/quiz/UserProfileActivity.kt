package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Get references to UI elements
        val usernameTextView = findViewById<TextView>(R.id.displayUsername)
        val emailTextView = findViewById<TextView>(R.id.displayEmail)
        val shareButton = findViewById<Button>(R.id.shareButton)

        // Dummy user data (Replace with actual user data if available)
        val username = "John Doe"
        val email = "john.doe@example.com"

        usernameTextView.text = "Username: $username"
        emailTextView.text = "Email: $email"

        // Handle Share Button Click
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Check out my profile!\n\nUsername: $username\nEmail: $email")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share Profile via"))
        }
    }
}
