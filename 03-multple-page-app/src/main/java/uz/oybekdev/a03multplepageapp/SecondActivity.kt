package uz.oybekdev.a03multplepageapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import uz.oybekdev.a03multplepageapp.databinding.ActivityMainBinding
import uz.oybekdev.a03multplepageapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val TAG = "activity_second"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"onCreate: ")

        binding.doneBn.setOnClickListener{
            val intent = Intent()
            val age = binding.ageEt.text.toString()
            intent.putExtra("age",age)
            setResult(Activity.RESULT_OK,intent) //deb natijanni qaytaramiz
            finish() //yopilishi uchun shunaqa qilamiz
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart: ")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume: ") // onResumedan keyin programma ishlatishga tayyor
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy: ")
    }


}