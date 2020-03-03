package com.example.ktmovies.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktmovies.contract.ChatContract
import com.example.ktmovies.domain.Answers
import com.example.ktmovies.rest.repository.ChatRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by danilorangel on 14/07/18.
 */

class ChatPresenter
@Inject
constructor(private val mView: ChatContract.View, private val mServiceApi: ChatRepository) : ChatContract.Presenter, ViewModel() {

    override fun sendAnswer(question: String) {
        viewModelScope.launch {
            mView.setAnswer(
            mServiceApi.getAnswers(Answers().apply {
                this.question = question
            }).answer)
        }
    }

}
