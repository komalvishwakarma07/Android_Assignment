package com.example.module3application.que_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.module3application.R
import com.example.module3application.que_3.User


class FirstFragment : Fragment() {

    lateinit var btnnext:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnnext=view.findViewById(R.id.btn_nextn)
        var etName = view.findViewById<EditText>(R.id.et_name)
        var etEmail = view.findViewById<EditText>(R.id.et_email)
        var etAge = view.findViewById<EditText>(R.id.et_age)

        btnnext.setOnClickListener {
            var name = etName.text.toString().trim()
            var email = etEmail.text.toString().trim()
            var age =
                if (etAge.text.toString().trim().isEmpty()) 0 else etAge.text.toString().trim().toInt()

            var user = User(name, email, age)

            var bundle=Bundle()
//            bundle.putString("NAME",name)
//            bundle.putString("EMAIL",email)
//            bundle.putInt("AGE",age)
            bundle.putParcelable("USER",user)




            var fragment=SecondFragment()
            fragment.arguments=bundle

            var manager=requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}