package com.example.fragmentvalidation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.module4application.R
import com.example.module4application.databinding.FragmentRagisterBinding
import com.example.module4application.utils.AppUtils
import com.google.android.material.textfield.TextInputLayout

class RagisterFragment : Fragment() {
        private lateinit var binding: FragmentRagisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRagisterBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_ragister, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignup.setOnClickListener {
            var name= binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contact=binding.etContact.text.toString().trim()
            var password=binding.etPassword.text.toString().trim()
            var cpassword= binding.etConfirmPassword.text.toString().trim()

            resetFocus()

            if (!AppUtils.isValidName(name)){
                showErroe(binding.inputName,"should be alphabet only")
            }
            else if (!AppUtils.isValidEmail(email)){
                showErroe(binding.inputEmail,"Invalid email")
            }
            else if (!AppUtils.isValidContact(contact)){
                showErroe(binding.inputContact,"Invalid contact")

            }
            else if (!AppUtils.isValidPassword(password)){
               showErroe( binding.inputPassword,"Invalid password")
            }
            else if (cpassword != password){
                binding.etConfirmPassword.setText("")
                showErroe(binding.inputConfirmPassword,"password mismatch")

            }else{
                Toast.makeText(requireContext(), "All Done", Toast.LENGTH_SHORT).show()
            }
        }
        binding.alreadyLogin.setOnClickListener {
            var fragment=LoginFragment()
            var manager=requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }

    }


    private fun resetFocus() {

        binding.inputName.error=null
        binding.inputEmail.error=null
        binding.inputContact.error=null
        binding.inputPassword.error=null
        binding.inputConfirmPassword.error=null
    }

    private  fun showErroe(inputLayout: TextInputLayout, message: String){
        inputLayout.error=message
        inputLayout.boxStrokeWidth=2
        inputLayout.requestFocus()
    }


    }