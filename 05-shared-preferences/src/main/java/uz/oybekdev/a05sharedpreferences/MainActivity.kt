package uz.oybekdev.a05sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.oybekdev.a05sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences:SharedPreferences //globalni qilib olish
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val sharedPreferences = getSharedPreferences() bunda biz xamma yerda foy.mumkin
        sharedPreferences = getPreferences(MODE_PRIVATE) // bunga nom berib bolmaydi
        //bunda faqat bittagina activityda ishlaydi
        counter = sharedPreferences.getInt("count",0) //bu yerda count key. 0 esa default
        //value .agar xotiradan topolmasa bizga 0 qaytaradi
        setContentView(binding.root)
        binding.counterTv.text = counter.toString()
        binding.incrementBtn.setOnClickListener {
            counter++
            binding.counterTv.text = counter.toString()

        }

    }

    override fun onStop() {
        sharedPreferences.edit().putInt("count",counter).apply() // bu yerda apply qushgin degani
        //putInt esa saqlagin
        super.onStop()
    }

}