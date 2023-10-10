package com.example.fragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.module3application.R
import com.example.module3application.que_3.User

class SecondFragment : Fragment() {

    lateinit var btnnext:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         btnnext=view.findViewById(R.id.btn_next)
        var etaddress=view.findViewById<EditText>(R.id.et_address)

        btnnext.setOnClickListener {
            var address=etaddress.text.toString().trim()

//            var name=arguments?.getString("NAME","")
//            var email=arguments?.getString("EMAIL","")
//            var age=arguments?.getInt("AGE")

           var user=arguments?.getParcelable<User>("USER")
            if (user != null){
//                etaddress.text = "${user.address }"
                user.address=address
            }





            var bundle=Bundle()
//            bundle.putString("ADDRESS",address)
//            bundle.putString("NAME",name)
//            bundle.putString("EMAIL",email)
//            if (age != null){
//                bundle.putInt("AGE",age)
            bundle.putParcelable("USER",user)

//            }





            var fragment=ThirdFragment()
            fragment.arguments=bundle

            var manager=requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }
    }

}


