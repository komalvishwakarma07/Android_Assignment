package com.example.module6application.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module6application.model.Item
import com.example.module7application.databinding.ItemLayoutBinding
import com.example.module7application.ques1.SplashActivity
import com.example.module7application.ques1.SplashhActivity
import com.example.module7application.ques2.PlaySongRowResourceActivity
import com.example.module7application.ques3.PlaySongMobileMemory
import com.example.module7application.ques4.PlaySongFromServerActivity
import com.example.module7application.ques5.VedioPlayActivity
import com.example.module7application.ques6.SpeechActivity
import com.example.module7application.ques7.WifiActivity

class ItemAdapter(var context: Context, var itemList: MutableList<Item>) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var binding=ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item=itemList[position]
        holder.binding.name.text = item.name

        holder.binding.cdView.setOnClickListener {
            when (item.id) {
                1 -> {
                    var intent = Intent(context, SplashActivity::class.java)
                    context.startActivity(intent)

                }

                2 -> {
                    var intent = Intent(context, PlaySongRowResourceActivity::class.java)
                    context.startActivity(intent)

                }

                3 -> {
                    var intent = Intent(context, PlaySongMobileMemory::class.java)
                    context.startActivity(intent)

                }

                4 -> {
                    var intent = Intent(context, PlaySongFromServerActivity::class.java)
                    context.startActivity(intent)

                }

                5 -> {
                    var intent = Intent(context, VedioPlayActivity::class.java)
                    context.startActivity(intent)

                }

                6 -> {
                    var intent = Intent(context, SpeechActivity::class.java)
                    context.startActivity(intent)

                }
                7 -> {
                    var intent = Intent(context, WifiActivity::class.java)
                    context.startActivity(intent)

                }

            }
        }

    }

}