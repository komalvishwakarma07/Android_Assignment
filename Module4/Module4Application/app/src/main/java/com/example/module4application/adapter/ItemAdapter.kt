package com.example.module4application.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module4application.databinding.ItemLayoutBinding
import com.example.module4application.model.Item
import com.example.module4application.que_1.ReversMainActivity
import com.example.module4application.que_10.PdfActivity
import com.example.module4application.que_11.FontActivity
import com.example.module4application.que_12.NnumberActivity
import com.example.module4application.que_13.CheckActivity
import com.example.module4application.que_14.ListActivity
import com.example.module4application.que_15.ColorActivity
import com.example.module4application.que_17.ToolbarActivity
import com.example.module4application.que_18.SpinnerActivity
import com.example.module4application.que_2.SecondActivity
import com.example.module4application.que_3.CalculationActivity
import com.example.module4application.que_4.OneActivity
import com.example.module4application.que_5.WebviewActivity
import com.example.module4application.que_6.NoAnsActivity
import com.example.module4application.que_8.HideActivity
import com.example.module4application.que_9.TableActivity

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
            when (item.id) {
                1 -> {
                    var intent = Intent(context, ReversMainActivity::class.java)
                    context.startActivity(intent)

                }
                2 ->{
                    var intent= Intent(context,SecondActivity::class.java)
                    context.startActivity(intent)

                }
                3 ->{
                    var intent= Intent(context, CalculationActivity::class.java)
                    context.startActivity(intent)

                }
                4 ->{
                    var intent= Intent(context, OneActivity::class.java)
                    context.startActivity(intent)

                }
                5 ->{
                    var intent= Intent(context,WebviewActivity::class.java)
                    context.startActivity(intent)

                }
                6 ->{
                    var intent= Intent(context,NoAnsActivity::class.java)
                    context.startActivity(intent)

                }
                7 ->{
                    var intent= Intent(context,NoAnsActivity::class.java)
                    context.startActivity(intent)

                }
                8->{
                    var intent= Intent(context, HideActivity::class.java)
                    context.startActivity(intent)

                }
                9 ->{
                    var intent= Intent(context,TableActivity::class.java)
                    context.startActivity(intent)

                }
                10 ->{
                    var intent= Intent(context,PdfActivity::class.java)
                    context.startActivity(intent)

                }
                11 ->{
                    var intent= Intent(context,FontActivity::class.java)
                    context.startActivity(intent)

                }
                12 ->{
                    var intent= Intent(context,NnumberActivity::class.java)
                    context.startActivity(intent)

                }
                13 ->{
                    var intent= Intent(context, CheckActivity::class.java)
                    context.startActivity(intent)

                }
                14 ->{
                    var intent= Intent(context, ListActivity::class.java)
                    context.startActivity(intent)

                }
                15 ->{
                    var intent= Intent(context, ColorActivity::class.java)
                    context.startActivity(intent)

                }
                16 ->{
                    var intent= Intent(context, NoAnsActivity::class.java)
                    context.startActivity(intent)

                }
                17 ->{
                    var intent= Intent(context, ToolbarActivity::class.java)
                    context.startActivity(intent)

                }
                18 ->{
                    var intent= Intent(context, SpinnerActivity::class.java)
                    context.startActivity(intent)

                }
            }
        }

    }
}
