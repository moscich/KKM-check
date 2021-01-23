package com.example.kk4.shared

data class LoginError(val message: String)

interface LoginService {
    fun login(user: String, pass: String, completion: (LoginError?, String?) -> (Unit))
}