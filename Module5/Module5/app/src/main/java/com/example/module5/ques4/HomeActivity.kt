package com.example.module5.ques4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiandroid.network.ApiClient
import com.example.module5.R
import com.example.module5.adapter.EmployeeAdapter
import com.example.module5.databinding.ActivityHomeBinding
import com.example.module5.databinding.ItemDialogLayoutBinding
import com.example.module5.model.Employee
import com.example.module5.model.RegisterResponse
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding

    private var itemList = mutableListOf<Employee>()
    private lateinit var itemAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = EmployeeAdapter(this, itemList)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = itemAdapter

        fetchUserData()

        itemAdapter.itemEditClickListener = { position, user ->
            showBottomSheetDialog(position, user)
        }
        itemAdapter.ItemdeleteListener = { position, user ->
            UserDeleteData(position, user)
        }
    }

    private fun fetchUserData() {
        ApiClient.init().getUsers(flag = 4).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    var userList = response.body()?.user
                    userList?.let {
                        itemAdapter.itemList = it
                        itemAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }

    private fun showBottomSheetDialog(position: Int, employee: Employee) {

        var bind = ItemDialogLayoutBinding.inflate(layoutInflater)
        bind.etname.setText(employee.name)
        bind.etemail.setText(employee.email)
        bind.etmobile.setText(employee.contact)
        var dialog = BottomSheetDialog(this)
        dialog.setContentView(bind.root)
        dialog.show()

        bind.update.setOnClickListener {
            employee.name = bind.etname.text.toString()
            employee.contact = bind.etmobile.text.toString()
            UserUpdate(position,employee)
            dialog.dismiss()
        }

    }

    private fun UserUpdate(position: Int, employee: Employee) {
        ApiClient.init().userupdate(2, employee.id, employee.name, employee.contact)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        var res = response.body()
                        if (res?.status == "success") {
                            if (position >= 0 && position < itemList.size) {
                                itemList[position] = employee
                                itemAdapter.updateList(itemList)
                            }
                        }

                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            })
    }

    private fun UserDeleteData(position: Int, employee: Employee) {
        ApiClient.init().Userdelete(3, employee.id)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        var res = response.body()
                        if (res?.status == "success") {
//                            itemAdapter.showDeleteDialog(position,employee)
                            runOnUiThread {
                                itemAdapter.showDeleteDialog(position, employee)
                            }
                        }

                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            })
    }
}