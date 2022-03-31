package fr.iim.mydummyapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    private lateinit var listener: MainFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.editTextButton).setOnClickListener {
            listener.OnHelloClickListener(
                view.findViewById<EditText>(R.id.editTextEmail).ttS(),
                view.findViewById<EditText>(R.id.editTextPassword).ttS(),
                view.findViewById<CheckBox>(R.id.checkBox).isChecked()
            )
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
        fun OnHelloClickListener(email: String, password: String, checkBox: Boolean)
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

    }
}