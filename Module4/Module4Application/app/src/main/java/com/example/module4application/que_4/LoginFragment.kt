package com.example.fragmentvalidation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.module4application.R
import com.example.module4application.databinding.FragmentLoginBinding
import com.example.module4application.utils.AppUtils


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

            resetFocus()

            if (!AppUtils.isValidEmail(email)) {
                // show error
                // binding.etEmail.error = "Enter valid email"
                // binding.etEmail.setBackgroundResource(R.drawable.et_error_bg)
                showError(binding.etEmail, "invalid email address")
            } else if (!AppUtils.isValidPassword(password)) {
                // show error
                //binding.etPassword.error = "Enter valid password"
                // binding.etPassword.setBackgroundResource(R.drawable.et_error_bg)
                showError(binding.etPassword, "invalid password")
            } else {
                Toast.makeText(requireContext(),"All Done",Toast.LENGTH_SHORT).show()
            }
        }




        binding.btnSignup.setOnClickListener{

                var fragment = RagisterFragment()
                var manager = requireActivity().supportFragmentManager
                var transaction = manager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()

            }


    }
    private fun resetFocus(){
        binding.etEmail.setBackgroundResource(R.drawable.et_white_bg)
        binding.etPassword.setBackgroundResource(R.drawable.et_white_bg)
    }
    private fun showError(editText: EditText, errorMsg:String){
        editText.setBackgroundResource(R.drawable.et_error_bg)
        Toast.makeText(requireContext(),"$errorMsg",Toast.LENGTH_SHORT).show()
        editText.requestFocus()
    }
}