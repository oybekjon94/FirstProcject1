package uz.oybekdev.generaterandomnumber

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.oybekdev.generaterandomnumber.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generate.setOnClickListener {
            Toast.makeText(this, "Button clicked",Toast.LENGTH_SHORT).show()
            val from = binding.slider.values[0]
            val to = binding.slider.values[1]

            if(binding.checkbox.isChecked){
                val randomNumber = Random.nextInt(from.toInt(), to.toInt())
                binding.redultTv.text = "generate number: %.3f $randomNumber"
            }else{
                val randomNumber = Random.nextDouble(from.toDouble(), to.toDouble())
                binding.redultTv.text = String.format("Generated Number : %.3f", randomNumber)

            }


        }
    }
}