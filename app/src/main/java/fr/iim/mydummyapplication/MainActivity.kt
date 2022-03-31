package fr.iim.mydummyapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MainFragment.MainFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, MainFragment.newInstance())
            .commitNow()
/*
//        val editTextFirstName: EditText = findViewById(R.id.editTextFirstName)
//        val editTextButton: Button = findViewById(R.id.editTextButton)
          editTextButton.setOnClickListener {
            //Go to next activity
            val message = editTextFirstName.text.toString()
            val intent = Intent(this, HelloActivity::class.java).apply {
                putExtra(HelloActivity.EXTRA_FIRST_NAME, message)
            }
            startActivity(intent)
            startActivity(HelloActivity.newInstance(this, editTextFirstName.text.toString()))
        }

        var firstName = "Maxime" //Can change value
        val lastName = "Attala" //Cannot change value
        findViewById<TextView>(R.id.main_content).setText("Kappa")
        findViewById<TextView>(R.id.main_content).setText(R.string.kappa)
        findViewById<TextView>(R.id.main_content).setText(getString(R.string.kappa))
        findViewById<TextView>(R.id.main_content).text = "Kappa"
        findViewById<TextView>(R.id.main_content).text = getString(R.string.kappa)
        */

    }

    override fun OnHelloClickListener(email: String, password: String, checkBox: Boolean) {
        Log.d(LOG_TAG, "click event set $email")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, HelloFragment.newInstance(email, password, checkBox))
            .commitNow()
    }

    companion object{
        private val LOG_TAG = "MainActivity"
    }
}