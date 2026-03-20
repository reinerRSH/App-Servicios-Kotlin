package com.example.myapplication.ViewModel

 sealed class registroState {

     object Cargando : registroState()
     object Exitoso : registroState()
     data class Error ( val mensaje : String) : registroState()
     object Vacio : registroState()
}