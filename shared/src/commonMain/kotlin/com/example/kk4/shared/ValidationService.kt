package com.example.kk4.shared

interface ValidationService {
    fun validateLogin(login: String): String?
    fun validatePass(pass: String): String?
}