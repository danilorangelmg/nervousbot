package com.example.ktmovies.contract

/**
 * Created by danilorangel on 15/07/18.
 */
interface ChatContract {

    interface View {
        fun setupView()
        fun setAnswer(answer: String)
    }

    interface Presenter {
        fun sendAnswer(answer: String)
    }

}