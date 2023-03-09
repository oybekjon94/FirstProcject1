package uz.oybekdev.a08_recyclerview

import android.app.Activity
import android.app.ActivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import uz.oybekdev.a08_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<String>()
        repeat(30){
            list.add("Title $it")
        }

        val customAdapter = MyCustomAdapter(list)

        val mylayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.recyclerView.apply {
            adapter = customAdapter
            layoutManager = mylayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity,mylayoutManager.orientation))
        }
    }
}