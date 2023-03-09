package uz.oybekdev.a08_recyclerview

import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import uz.oybekdev.a08_recyclerview.databinding.ItemListLayoutBinding

class MyCustomAdapter(val list:List<String>):RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding:ItemListLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(title: String){
            binding.titleTv.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = list[position]
        holder.bind(title)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}