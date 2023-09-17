package com.example.fragmentspractice

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.replace
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add the default fragment to the activity
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FirstFragment>(R.id.fragmentContainer)
        }

        // Call a button of the activity that will replace the fragment
        val buttonFragment1 = findViewById<Button>(R.id.buttonFragment1)
        val buttonFragment2 = findViewById<Button>(R.id.buttonFragment2)

        // Listener
        buttonFragment1.setOnClickListener(){
            supportFragmentManager.commit {
                setReorderingAllowed(true)

                // Replace the fragment with the id fragmentContainer with the FirstFragment
                replace<FirstFragment>(R.id.fragmentContainer)
            }
        }

        // Listener
        buttonFragment2.setOnClickListener(){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainer, SecondFragment())
            }
        }

    }

    
}
