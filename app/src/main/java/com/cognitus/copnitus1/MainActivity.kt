package com.cognitus.copnitus1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.cognitus.copnitus1.databinding.ActivityMainBinding
import com.cognitus.copnitus1.utils.AlertDialogCustom

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.clickListener = this
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_1 -> {
                if(binding.inpUser.text.toString().isEmpty()) {
                    /**
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Mensaje del sistema")
                    builder.setMessage("Debes colocar datos >:v!")

                    //boton ok
                    builder.setPositiveButton(android.R.string.yes){ dialog, which ->
                        Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                    }

                    //boton cancel
                    builder.setNegativeButton(android.R.string.no){ dialog, whitch -> Toast.makeText(applicationContext, android.R.string.no, Toast.LENGTH_SHORT).show()
                    }

                    //boton maybe
                    builder.setNeutralButton("Tal vez"){ dialog, which -> Toast.makeText(applicationContext, "Tal vez", Toast.LENGTH_SHORT).show()
                    }
                    builder.show()
                    */

                    AlertDialogCustom.createSimpleAlert(
                        this,
                        "Mensaje del sistema",
                        "!Debes de iniciar tu sesión >:v!",
                        false,
                        R.string.txtBtnCancel
                    )
                } else {
                    //Toast.makeText(this, "Hola tocaste el boton", Toast.LENGTH_LONG).show()
                    val sharedPreferences =
                        getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("username", binding.inpUser.text.toString())
                    editor.apply()
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}