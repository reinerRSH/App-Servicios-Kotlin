package com.example.myapplication.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.autoRepository
import com.example.myapplication.model.usuarios

class LoginViewModel {

    private val repository = autoRepository()


    val estadoRegistro = MutableLiveData<registroState>(registroState.Vacio)


    fun crearCuenta(usuario: usuarios) {
        when {

            usuario.nombre.isBlank() -> estadoRegistro.value =
                registroState.Error("Debe colocar un nombre ")

            usuario.correo.isBlank() -> estadoRegistro.value =
                registroState.Error("Debe colocar un correo ")

            usuario.pasword.length < 6 -> estadoRegistro.value =
                registroState.Error("la contraseña debe tener al menos 6 caracteres")

            !android.util.Patterns.EMAIL_ADDRESS.matcher(usuario.correo)
                .matches() -> estadoRegistro.value =
                registroState.Error("Email invalido")

            else -> {
                estadoRegistro.value = registroState.Cargando
                repository.registrarUsuario(
                    usuario,
                    onSuccess = { estadoRegistro.value = registroState.Exitoso },
                    onFailure = { e ->
                        estadoRegistro.value = registroState.Error(e.message ?: "Error desconocido")
                    }
                )


            }


        }
    }
}