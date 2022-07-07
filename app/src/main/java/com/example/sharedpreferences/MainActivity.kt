package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences( "data", Context.MODE_PRIVATE )

        //set data into shared preferences
        binding.btnSubmit.setOnClickListener {
            val name = binding.txtInputName.editText?.text.toString()
            sharedPreferences.edit().putString("name",name).apply()

            val email = binding.txtInputEmail.editText?.text.toString()
            sharedPreferences.edit().putString("email",email).apply()

            if (binding.radioMale.isChecked){
                //user is male =>
                sharedPreferences.edit().putBoolean("isMale",true).apply()

            }else{
                //user is female
                sharedPreferences.edit().putBoolean("isFemale",false).apply()

            }


            //way 2 =>
//            val editor = sharedPreferences.edit()
//            editor.putString("name",name)
//            editor.putString("email",email)
//            if (binding.radioMale.isChecked){
//                //user is male =>
//                editor.putBoolean("isMale",true)
//
//            }else{
//                //user is female
//                editor.putBoolean("isFemale",false).apply()
//            }
//            editor.apply()

        }
        //get from shared preferences
        val name = sharedPreferences.getString("name","")
        val email=sharedPreferences.getString("email","")
        val isMale=sharedPreferences.getBoolean("isMale",true)

        binding.txtInputName.editText?.setText(name)
        binding.txtInputEmail.editText?.setText(email)

        if (isMale){
            //Male =>
            binding.radioMale.isChecked=true
        }else{
            binding.radioFemale.isChecked=true
        }

//        //for Search exit =>
//        val isNameAvailable = sharedPreferences.contains("name") => boolean
//        //for remove an item =>
//        sharedPreferences.edit().remove("email").apply()
//        //for clean sharedPreference (remove xml file)=>
//        sharedPreferences.edit().clear().apply()
    }
}