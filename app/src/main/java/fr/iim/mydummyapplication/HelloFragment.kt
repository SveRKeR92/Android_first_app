package fr.iim.mydummyapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Matcher
import java.util.regex.Pattern

class HelloFragment : Fragment() {
    private var email: String? = null
    private var password: String? = null
    private var checkBox: Boolean? = null

    private fun isMailValid(mail: String?): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail.toString()).matches();
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        val pattern: Pattern = Pattern.compile(passwordPattern);
        val matcher: Matcher = pattern.matcher(password);
        return matcher.matches();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            email = it.getString(ARG_EMAIL)
            password = it.getString(ARG_PASSWORD)
            checkBox = it.getBoolean(ARG_CHECKBOX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.mapButton).setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            startActivity(intent)
        }

        if (isMailValid(email.toString()) && isPasswordValid(password.toString()) && checkBox == true){
            view.findViewById<TextView>(R.id.helloFragmentTextView).text = getString(R.string.hello, email)
        }
        else {
            view.findViewById<TextView>(R.id.helloFragmentTextView).text = "Wrong identifiers, or check the box"
        }
    }

    companion object {
        private const val ARG_EMAIL = "email"
        private const val ARG_PASSWORD = "password"
        private const val ARG_CHECKBOX = "checkbox"

        @JvmStatic
        fun newInstance(email: String, password: String, checkBox: Boolean) =
            HelloFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_EMAIL, email)
                    putString(ARG_PASSWORD, password)
                    putBoolean(ARG_CHECKBOX, checkBox)
                }
            }
    }
}