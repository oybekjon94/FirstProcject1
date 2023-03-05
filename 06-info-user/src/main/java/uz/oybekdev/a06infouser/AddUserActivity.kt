package uz.oybekdev.a06infouser

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.oybekdev.a06infouser.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddUserBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("db", MODE_PRIVATE)

        binding.imageView1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in_anim))
        binding.saveBtn.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_bottom))
        binding.editTextTextPersonName.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_left))
        binding.surnameEt.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_right))
        binding.editTextTextPersonName3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_left))

        binding.saveBtn.setOnClickListener {

            val name = binding.editTextTextPersonName.text.toString()
            val surname = binding.surnameEt.text.toString()
            val age = binding.editTextTextPersonName3.text.toString()
            if (name.isNotBlank()&&surname.isNotBlank()&&age.isNotBlank()){
                sharedPreferences.edit().putString("name",name).apply()
                sharedPreferences.edit().putString("surname",surname).apply()
                sharedPreferences.edit().putString("age",age).apply()

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Tepadagi barcha maalumotlar toldirilishi shart",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        if (sharedPreferences.getString("name","")!=""){ //agar empty bolmasa demak malumot bor
            // va keyingi page ga otkazib yuboradi
            Intent(this,MainActivity::class.java).apply {
                //apply shu intentimizni beradi.yangi boshqa var ochmasdan shuni ichidan
                startActivity(this)
                finish()
            }
        }
        super.onStart()
    }
}