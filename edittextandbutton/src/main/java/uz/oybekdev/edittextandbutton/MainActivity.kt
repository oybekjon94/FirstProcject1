package uz.oybekdev.edittextandbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEt = findViewById<EditText>(R.id.nameEt)
        val nameTv = findViewById<TextView>(R.id.nameTv)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            nameTv.text = "Assalamu aleykum ${nameEt.text}"
        }
    }
}