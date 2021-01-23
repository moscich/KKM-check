package com.example.kk4.shared

class MarekApp(private val loginUI: LoginUI,
               private val loginService: LoginService = LocalLoginService(),
               private val validationService: ValidationService = ValidationServiceImpl()): Input {
    init {
        loginUI.loginAction = {
            loginService.login(loginUI.login, loginUI.pass) { error, token ->
                if (error != null) {
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
        return validationService.validateLogin(loginUI.login) != null
                && validationService.validatePass(loginUI.pass) != null
    }

    override fun buttonPressed() {

    }
}