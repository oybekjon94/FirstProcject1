package uz.oybekdev.a03multplepageapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import uz.oybekdev.a03multplepageapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "activity_main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            //startActivity(intent) // keyingi activityga o't
            startActivityForResult(intent,77)
        }
        // onStart
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {  //bunda bazamzni yangilab olishimiz yoki request jonatishimiz etc.
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



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 77 && resultCode == Activity.RESULT_OK){
            val age = data?.getStringExtra("age") // ikkinchi activitydagi age key bilan bir
            // bolishi kerak
            binding.resultTV.text = age
        }
    }
}