package com.example.module4application.utils

import android.util.Patterns
import java.util.regex.Pattern

class AppUtils {
    companion object{
        const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        private  const val NAME_PATTERN = "[a-zA-Z]+$"

        fun isValidEmail(email:String):Boolean{
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        fun isValidPassword(password:String):Boolean{
            return Pattern.matches(PASSWORD_PATTERN,password)
        }
        fun isValidName(name:String):Boolean{
            return Pattern.matches(NAME_PATTERN,name)
        }
        fun isValidContact(contact:String):Boolean{
            return contact.length==10

        }

    }
}