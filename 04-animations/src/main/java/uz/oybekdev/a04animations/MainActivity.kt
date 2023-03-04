package uz.oybekdev.a04animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import uz.oybekdev.a04animations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alphaBtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.alpha_anim)
            binding.imageView2.startAnimation(animation)
        }
        binding.roatetBtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.rotate_anim)
            binding.imageView2.startAnimation(animation)
        }
        binding.translateBtn.setOnClickListener{
            val animation = AnimationUtils.loadAnimation(this,R.anim.translate_anim)
            binding.imageView2.startAnimation(animation)
        }
        binding.scaleBtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.scale_anim)
            binding.imageView2.startAnimation(animation)
        }
        binding.combinationBtn.setOnClickListener {
            val animation= AnimationUtils.loadAnimation(this,R.anim.combination_anim)
            binding.imageView2.startAnimation(animation)
        }
    }
}