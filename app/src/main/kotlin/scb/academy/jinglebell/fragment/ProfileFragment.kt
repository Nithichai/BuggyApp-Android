package scb.academy.jinglebell.fragment


import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.WelcomeActivity


class ProfileFragment : Fragment() {

    private lateinit var profileEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileEditText = view.findViewById(R.id.profile_edit_text)
        profileEditText.apply {
            setOnKeyListener { view, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    val intent = Intent(view.context, WelcomeActivity::class.java)
                    intent.putExtra("name", profileEditText.text.toString())
                    startActivity(intent)
                    true
                }
                false
            }
        }
    }


}
