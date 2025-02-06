package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Get references to UI elements
        val profileTitle = findViewById<TextView>(R.id.profileTitle)
        val displayUsername = findViewById<TextView>(R.id.displayUsername)
        val displayEmail = findViewById<TextView>(R.id.displayEmail)
        val logOutButton = findViewById<Button>(R.id.logOutButton)

        // Retrieve user data (this can be retrieved from SharedPreferences or database)
        val username = "JohnDoe"  // Replace with dynamic username (from SharedPreferences or DB)
        val email = "johndoe@example.com"  // Replace with dynamic email (from SharedPreferences or DB)

        // Set the data dynamically
        displayUsername.text = "Username: $username"
        displayEmail.text = "Email: $email"

        // Handle Log Out Button Click
        logOutButton.setOnClickListener {
            // Clear the user session or perform any other logout-related actions
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_SHORT).show()

            // Example: Go back to the Login Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Optional: If you don't want the user to return to this page
        }
    }
}
