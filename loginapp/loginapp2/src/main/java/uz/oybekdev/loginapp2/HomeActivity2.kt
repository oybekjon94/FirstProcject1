package uz.oybekdev.loginapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.oybekdev.loginapp2.databinding.ActivityHome2Binding

class HomeActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityHome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener{
            startActivity(Intent(this,LoginActivity2::class.java))
        }
    }
}