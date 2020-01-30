package com.s.fivebrains.mvp.model

data class User(
    var name: String = "",
    var email: String = ""

) {
    override fun toString(): String {
        return "User(name='$name', email='$email')"
    }
}