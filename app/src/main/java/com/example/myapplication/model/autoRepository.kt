package com.example.myapplication.model

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class autoRepository {

    private val db = Firebase.firestore


    fun registrarUsuario(
        usuarios: usuarios,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {


        db.collection("usuarios").document(usuarios.correo)
            .set(usuarios)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onFailure(e) }

    }
}