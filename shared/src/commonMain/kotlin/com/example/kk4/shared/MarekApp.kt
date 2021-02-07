package com.example.kk4.shared

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MarekApp(private val loginUI: LoginUI,
               private val loginService: LoginService = LocalLoginService(),
               private val validationService: ValidationService = ValidationServiceImpl()): Input {
    private val mainScope = MainScope()
    init {



        loginUI.loginAction = {
            loginService.login(loginUI.login, loginUI.pass) { error, token ->
                if (error != null) {
                    val api = SomeApi()
                    mainScope.launch {
                        kotlin.runCatching {
                            val x = api.gogo()
                            loginUI.passValidError = x.name
                            x
                        }.onSuccess {
                            loginUI.passValidError = it.name
                        }.onFailure {
                            loginUI.loginValidError = it.message.toString()
                        }
                    }
                    loginUI.alert = error.message
                } else {
//TODO do login
                }
            }
        }

        loginUI.loginLostFocus = {
            val validateLogin = validationService.validateLogin(loginUI.login)
            if (validateLogin != null) {
                loginUI.loginValidError = validateLogin
            } else {
                loginUI.loginValidError = ""
            }
            handleLoginButton()
        }

        loginUI.passLostFocus = {
            val validatePass = validationService.validatePass(loginUI.pass)
            if (validatePass != null) {
                loginUI.passValidError = validatePass
            } else {
                loginUI.passValidError = ""
            }
            handleLoginButton()
        }
    }

    private fun handleLoginButton() {

        loginUI.loginButtonEnabled = allGood()
    }

    private fun allGood(): Boolean {
        return validationService.validateLogin(loginUI.login) == null
                && validationService.validatePass(loginUI.pass) == null
    }

    override fun buttonPressed() {

    }
}