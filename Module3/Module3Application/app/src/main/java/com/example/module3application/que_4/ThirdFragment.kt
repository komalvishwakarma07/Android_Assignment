package com.example.module3application.que_4

import android.os.Bundle
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.module3application.R
import com.example.module3application.que_3.User

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var tvname = view.findViewById<TextView>(R.id.tv_name)
        var tvemail = view.findViewById<TextView>(R.id.tv_email)
        var tvage = view.findViewById<TextView>(R.id.tv_age)
        var tvaddress = view.findViewById<TextView>(R.id.tv_address)



//        var name = arguments?.getString("NAME", "")
//        var email = arguments?.getString("EMAIL", "")
//        var age = arguments?.getInt("AGE")
//        var address = arguments?.getString("ADDRESS", "")

        var user=arguments?.getParcelable<User>("USER")

//        if (name != null && email != null && address != null) {
//            tvname.text = "$name"
//            tvemail.text = "$email"
//            tvage.text = "$age"
//            tvaddress.text = "$address"
//        }

        if (user != null){
            tvname.text = "${user.name}"
            tvemail.text = "${user.email}"
            tvage.text = "${user.age}"
            tvaddress.text = "${user.address}"
        }


    }


}