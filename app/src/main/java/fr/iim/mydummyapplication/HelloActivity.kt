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

        val message = intent.getStringExtra(EXTRA_FIRST_NAME)
        findViewById<TextView>(R.id.helloFragmentTextView).text = getString(R.string.hello, message)

    }

    companion object {
        const val EXTRA_FIRST_NAME = "HELLO_FIRST_NAME"

        fun newInstance(context: Context, firstName : String): Intent{
            return Intent(context, HelloActivity::class.java).apply {
                putExtra(EXTRA_FIRST_NAME, firstName)
            }
        }
    }
}