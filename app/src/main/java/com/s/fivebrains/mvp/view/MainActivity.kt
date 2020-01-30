package com.s.fivebrains.mvp.view

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.s.fivebrains.mvp.R
import com.s.fivebrains.mvp.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RelativeLayout
import android.widget.ProgressBar







class MainActivity : AppCompatActivity(), MainActivityPresenter.View {
    override fun updateUserInfoTextView(info: String) {
        header.text = info
    }

    override fun showProgressBar() {
     progressBar.visibility= View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility=View.GONE
    }

    private lateinit var presenter:MainActivityPresenter
    private lateinit var progressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter= MainActivityPresenter(this)

        init()
        initPro()
    }

    private fun initPro() {
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)
        progressBar.isIndeterminate = true
        val params = RelativeLayout.LayoutParams(
            Resources.getSystem().displayMetrics.widthPixels,
            250
        )
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        this.addContentView(progressBar, params)
        showProgressBar()
    }

    private fun init() {

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter.updateEmail(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                hideProgressBar()
            }
        })



        name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter.updateName(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                hideProgressBar()
            }
        })
    }



}
