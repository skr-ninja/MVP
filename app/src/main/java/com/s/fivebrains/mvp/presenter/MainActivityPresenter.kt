package com.s.fivebrains.mvp.presenter

import com.s.fivebrains.mvp.model.User

class MainActivityPresenter(private val view: View) {

    private val user: User = User()

    fun updateName(name: String) {
        user.name = name
        view.updateUserInfoTextView(user.toString())

    }

    fun updateEmail(email: String) {
        user.email = email
        view.updateUserInfoTextView(user.toString())

    }

    interface View {

        fun updateUserInfoTextView(info: String)
        fun showProgressBar()
        fun hideProgressBar()

    }
}