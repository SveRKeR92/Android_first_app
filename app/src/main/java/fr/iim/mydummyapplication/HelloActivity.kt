package fr.iim.mydummyapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.security.AccessControlContext

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val message = intent.getStringExtra(EXTRA_EMAIL)
        findViewById<TextView>(R.id.helloFragmentTextView).text = getString(R.string.hello, message)

    }

    companion object {
        const val EXTRA_EMAIL = "HELLO_EMAIL"

        fun newInstance(context: Context, email : String): Intent{
            return Intent(context, HelloActivity::class.java).apply {
                putExtra(EXTRA_EMAIL, email)
            }
        }
    }
}