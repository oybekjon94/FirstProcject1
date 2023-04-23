package uz.oybekdev.loginapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import uz.oybekdev.loginapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var username : EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.loginButton.setOnClickListener { View.OnClickListener {
            if (binding.userName.text.toString() == "user" && binding.password.text.toString() == "1234"){
                Toast.makeText(this,"Login Successful!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
            }
        } }
    }
}