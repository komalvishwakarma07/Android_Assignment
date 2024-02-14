package com.example.module6application.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module6application.ques7.ZoomActivity
import com.example.module6application.databinding.ItemLayoutBinding
import com.example.module6application.model.Item
import com.example.module6application.que1.PicActivity
import com.example.module6application.que6.RotateImageActivity
import com.example.module6application.ques2.MapsActivity
import com.example.module6application.ques3.AddressActivity
import com.example.module6application.ques4.AutocompleteActivity
import com.example.module6application.ques5.GoogleActivity
import com.example.module6application.ques8.FrameAnimation
import com.example.module6application.ques9.SplashActivity

class ItemAdapter(var context: Context, var itemList: MutableList<Item>) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(var binding:ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

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
                    var intent = Intent(context, PicActivity::class.java)
                    context.startActivity(intent)

                }

                2 -> {
                    var intent = Intent(context, MapsActivity::class.java)
                    context.startActivity(intent)

                }

                3 -> {
                    var intent = Intent(context, AddressActivity::class.java)
                    context.startActivity(intent)

                }
                4 -> {
                    var intent = Intent(context, AutocompleteActivity::class.java)
                    context.startActivity(intent)

                }
                5 -> {
                    var intent = Intent(context, GoogleActivity::class.java)
                    context.startActivity(intent)

                }

                6 -> {
                    var intent = Intent(context, RotateImageActivity::class.java)
                    context.startActivity(intent)

                }
                7 -> {
                    var intent = Intent(context, ZoomActivity::class.java)
                    context.startActivity(intent)

                }
                8 -> {
                    var intent = Intent(context,FrameAnimation::class.java)
                    context.startActivity(intent)
                }
                9 -> {
                    var intent = Intent(context, SplashActivity::class.java)
                    context.startActivity(intent)

                }
            }
        }

    }

}