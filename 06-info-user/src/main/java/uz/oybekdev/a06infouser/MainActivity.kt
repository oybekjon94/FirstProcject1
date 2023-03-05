package uz.oybekdev.a06infouser

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.oybekdev.a06infouser.databinding.ActivityAddUserBinding
import uz.oybekdev.a06infouser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPrefences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefences = getSharedPreferences("db", Context.MODE_PRIVATE)
        binding.nameTv.text = sharedPrefences.getString("name","")
        binding.surnameTv.text = sharedPrefences.getString("surname","")
        binding.ageTv.text = sharedPrefences.getString("age","")

        //qachonki clear btn boosilganda malumotlarimizni ochirib yuborishimzi kerak
        binding.clearBtn.setOnClickListener {
            sharedPrefences.edit().clear().apply()
            //edit -> barcha malumotlarni clear-> ochirib tashlaydi va shuni applly-> bazaga yozib quyadi
            finish() //chiqib ketish
        }

    }
}