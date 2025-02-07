package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // References to UI elements
        val profileName = findViewById<TextView>(R.id.profileName)
        val profileStats = findViewById<TextView>(R.id.profileStats)
        val shareProfile = findViewById<Button>(R.id.shareProfile)

        // Example data (this could come from a database or intent extras)
        val username = "John Doe"
        val followers = 52
        val following = 20

        // Set data to UI elements
        profileName.text = username
        profileStats.text = "$followers followers · $following following"

        // Handle Share Profile button click (Implicit Intent)
        shareProfile.setOnClickListener {
            val shareText = "Check out $username's profile on Quiz App: $followers followers and $following following!"
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            // Start the intent if there's an app that can handle it
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Share Profile Using"))
            } else {
                Toast.makeText(this, "No apps available to share", Toast.LENGTH_SHORT).show()
            }
        }

        // Additional actions for navigation (example setup)
        val navLibrary = findViewById<ImageView>(R.id.navLibrary)
        val navHome = findViewById<ImageView>(R.id.navHome)
        val navSettings = findViewById<ImageView>(R.id.navSettings)

        navLibrary.setOnClickListener {
            Toast.makeText(this, "Navigating to Library", Toast.LENGTH_SHORT).show()
            // Add navigation logic here
        }

        navHome.setOnClickListener {
            Toast.makeText(this, "Navigating to Home", Toast.LENGTH_SHORT).show()
            // Add navigation logic here
        }

        navSettings.setOnClickListener {
            Toast.makeText(this, "Navigating to Settings", Toast.LENGTH_SHORT).show()
            // Add navigation logic here
        }
    }
}
