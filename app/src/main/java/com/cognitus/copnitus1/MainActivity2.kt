package com.cognitus.copnitus1

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.cognitus.copnitus1.databinding.ActivityMain2Binding
import com.cognitus.copnitus1.utils.AlertDialogCustom

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "0")
        binding.txtUserLogin.text = username;
        binding.clickListener = this
        if (username !== "0") {
            Toast.makeText(this, "Hola $username de nuevo!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogout->{
                AlertDialogCustom.createOptionalAlert(
                    this,
                    "Cerrar sesión",
                    "¿Esta seguro de cerrar la sesión?",
                    false,
                    R.string.txtBtnAcepted,
                    R.string.txtBtnCancel,
                    listenerPositive = {
                        //cierra la sesión
                        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.clear()
                        editor.remove("username")
                        editor.apply()
                        Toast.makeText(this, "La sesión se ha cerrado!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    },
                    listenerNegative = {
                        Toast.makeText(applicationContext, "Se cancela todo", Toast.LENGTH_SHORT).show()
                    }
                )

                /***
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Cerrar Sessión")
                builder.setMessage("¿Esta seguro de cerrar su sessión?")
                //btn ok
                builder.setPositiveButton(android.R.string.yes) {
                    dialog, whitch -> Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()

                    //cierra la sesión
                    val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.clear()
                    editor.remove("username")
                    editor.apply()
                    Toast.makeText(this, "La sesión se ha cerrado!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()


                }

                //btn cancel
                //boton cancel
                builder.setNegativeButton(android.R.string.no){ dialog, whitch -> Toast.makeText(applicationContext, android.R.string.no, Toast.LENGTH_SHORT).show()
                }
                builder.show()
                */

            }
            R.id.imgNews -> {
                //Toast.makeText(this, "Ir a noticias proximamente", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ListNewsActivity::class.java)
                startActivity(intent)

            }
            R.id.imgProducts -> {
                Toast.makeText(this, "Ir a productos proximamente", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ListadoActivity::class.java)
                startActivity(intent)
            }
            R.id.imgAbout -> {
                Toast.makeText(this, "Ir a productos proximamente", Toast.LENGTH_LONG).show()
            }
            R.id.imgContact -> {
                Toast.makeText(this, "Ir a productos proximamente", Toast.LENGTH_LONG).show()
            }
        }
    }

}