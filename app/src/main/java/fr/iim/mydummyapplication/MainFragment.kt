package fr.iim.mydummyapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainFragment : Fragment() {

    private lateinit var listener: MainFragmentListener

    private var validEmailInput: Boolean = false
    private var validPasswordInput: Boolean = false

    private fun isMailValid(mail: String?): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail.toString()).matches();
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        val pattern: Pattern = Pattern.compile(passwordPattern);
        val matcher: Matcher = pattern.matcher(password);
        return matcher.matches() && password.length >= 8;
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emailInput = view.findViewById<EditText>(R.id.editTextEmail)
        val passwordInput = view.findViewById<EditText>(R.id.editTextPassword)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBox)
        val button = view.findViewById<Button>(R.id.editTextButton)

        button.isEnabled = false

        button.setOnClickListener {
            listener.OnHelloClickListener(
                emailInput.ttS()
            )
        }

        emailInput.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    validEmailInput = isMailValid(s.toString())
                    button.isEnabled = validEmailInput && validPasswordInput && checkBox.isChecked
                }
            }
        )
        passwordInput.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    validPasswordInput = isPasswordValid(s.toString())
                    button.isEnabled = validEmailInput && validPasswordInput && checkBox.isChecked
                }
            }
        )

        checkBox.setOnClickListener {
            button.isEnabled = validEmailInput && validPasswordInput && checkBox.isChecked
        }

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MainFragmentListener){
            listener = context
        }else {
            throw RuntimeException("$context must implement MainFragment.MainFragmentListener")
        }
    }

    interface MainFragmentListener{
        fun OnHelloClickListener(email: String)
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

    }
}