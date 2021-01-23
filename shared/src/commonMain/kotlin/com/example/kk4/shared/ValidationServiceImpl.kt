package com.example.kk4.shared

class ValidationServiceImpl: ValidationService {
    override fun validateLogin(login: String): String? {
        if (login.length < 2) {
            return "Login must have at least 2 char"
        }
        return null
    }

    override fun validatePass(pass: String): String? {
        if (pass.toLowerCase() == pass) {
            return "Pass must have at least 1 Uppercase"
        }
        return null
    }
}