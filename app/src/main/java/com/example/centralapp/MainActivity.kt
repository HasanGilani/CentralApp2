package com.example.centralapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openCalculator: Button = findViewById(R.id.openCalculator)
        val openAffirmation: Button = findViewById(R.id.openAffirmation)

        openCalculator.setOnClickListener {
            replaceFragment(CalculatorFragment())
        }

        openAffirmation.setOnClickListener {
            val affirmationFragment = AffirmationFragment.newInstance()
            replaceFragment(affirmationFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}