package com.example.android.androidsearchview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val loginRepository=
        LoginRepository()

    fun login(){
        viewModelScope.launch(Dispatchers.IO) {
            loginRepository.makeLoginRequest()
        }
    }
}