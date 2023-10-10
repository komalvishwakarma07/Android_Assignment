package com.example.module3application.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module3application.databinding.ItemLayoutBinding
import com.example.module3application.model.Item
import com.example.module3application.que_1.HelloWordActivity
import com.example.module3application.que_2.ColorActivity
import com.example.module3application.que_3.FirstActivity
import com.example.module3application.que_5.RegisterPage
import com.example.module3application.que_6.RJavaActivity
import com.example.module3application.que_7.ActivityLifeCycle
import com.example.module3application.que_8.FragmentLifecycle
import com.example.module3application.que_9.SecondActivity

class ItemAdapter(var context: Context, var itemList : MutableList<Item>): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding=ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = itemList[position]
        holder.binding.name.text=item.name

        holder.binding.cdView.setOnClickListener {
            when(item.id){
                1 ->{
                    var intent= Intent(context,HelloWordActivity::class.java)
                    context.startActivity(intent)

                }
                2 ->{
                    var intent= Intent(context,ColorActivity::class.java)
                    context.startActivity(intent)

                }
                3 ->{
                    var intent= Intent(context,FirstActivity::class.java)
                    context.startActivity(intent)

                }
                4 ->{
                    var intent= Intent(context,FirstActivity::class.java)
                    context.startActivity(intent)

                }
                5 ->{
                    var intent= Intent(context,RegisterPage::class.java)
                    context.startActivity(intent)

                }
                6 ->{
                    var intent= Intent(context,RJavaActivity::class.java)
                    context.startActivity(intent)

                }
                7 ->{
                    var intent= Intent(context,ActivityLifeCycle::class.java)
                    context.startActivity(intent)

                }
                8->{
                    var intent= Intent(context,FragmentLifecycle::class.java)
                    context.startActivity(intent)

                }
                9 ->{
                    var intent= Intent(context,SecondActivity::class.java)
                    context.startActivity(intent)

                }
            }
        }

       }
    }
