package uz.oybekdev.loginapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.oybekdev.loginapp2.databinding.ActivityLogin2Binding
import uz.oybekdev.loginapp2.databinding.ActivityRegister2Binding

class RegisterActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityRegister2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            startActivity(Intent(this,LoginActivity2::class.java))
        }
        binding.tvHaveAccount.setOnClickListener {
            startActivity(Intent(this,LoginActivity2::class.java))
        }
    }
}