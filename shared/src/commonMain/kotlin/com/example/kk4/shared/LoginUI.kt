package com.example.kk4.shared

interface LoginUI {
    var login: String
    var pass: String

    var loginValidError: String
    var passValidError: String

    var loginButtonEnabled: Boolean

    var alert: String

    var loginAction: (() -> (Unit))?
    var loginLostFocus: (() -> (Unit))?
    var passLostFocus: (() -> (Unit))?
}