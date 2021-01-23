package com.example.kk4.shared

class LocalLoginService: LoginService {
    override fun login(user: String, pass: String, completion: (LoginError?, String?) -> (Unit)) {
        if (user == "Janusz" && pass == "Test") {
            completion(null, "random token")
        } else {
            completion(LoginError("Login failed"), null)
        }
    }
}