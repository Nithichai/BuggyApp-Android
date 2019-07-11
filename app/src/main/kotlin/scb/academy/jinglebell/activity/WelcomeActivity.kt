package scb.academy.jinglebell.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import scb.academy.jinglebell.R

class WelcomeActivity : AppCompatActivity() {

    private lateinit var textName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        textName = findViewById(R.id.profile_textview)
        textName.apply {
            intent.extras?.let {
                val name: String = intent.extras!!.getString("name", "")
                textName.text = name
            }
        }
    }
}
