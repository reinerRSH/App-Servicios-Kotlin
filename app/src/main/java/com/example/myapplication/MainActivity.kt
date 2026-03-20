package com.example.myapplication

import com.example.myapplication.model.dataUsuario
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

// se agrega binding en la activity

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        logInConfig()
    }

    fun mostrarMensaje(mensaje: String) {
        android.widget.Toast.makeText(this, mensaje, android.widget.Toast.LENGTH_SHORT).show()

    }

    fun logInConfig() {

        val usuarios = dataUsuario.usuarios

        val cbRegistro =
            findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.cb_registro)

        cbRegistro.visibility = android.view.View.GONE


        // contenedores de texto
        val tilEmail = findViewById<TextInputLayout>(R.id.til_email)
        val tilPassword = findViewById<TextInputLayout>(R.id.password)

        //caja de texto
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val loginButton = findViewById<MaterialButton>(R.id.login)


        loginButton.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            tilEmail.error = null
            tilPassword.error = null

            when {
                email.isEmpty() || password.isEmpty() -> mostrarMensaje("Rellene todo los campos")
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> tilEmail.error =
                    "Email invalido"

                password.length < 6 -> tilPassword.error =
                    "la contraseña debe tener al menos 6 caracteres"

                usuarios.containsKey(email) -> {
                    if (usuarios[email] != password) {
                        tilPassword.error = "Contraseña incorrecta"
                    } else {
                        val intent = Intent(this, homeActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                !cbRegistro.isChecked -> {
                    mostrarMensaje("usuario no encontrado")
                    cbRegistro.visibility = android.view.View.VISIBLE

                    loginButton.text = getString(R.string.button_text)

                }

                else -> {
                    usuarios[email] = password
                    mostrarMensaje("Registro exitoso")
                    cbRegistro.isChecked = false
                    cbRegistro.visibility = android.view.View.GONE

                    loginButton.text = getString(R.string.Log_inButton)


                }


            }
        }
    }
}