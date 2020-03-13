package com.example.ktmovies.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

class ChatViewModel
@Inject
constructor(private val mServiceApi: ChatRepository) : ViewModel() {

    private val _messageLiveData = MutableLiveData<String>()
    val messageLiveDate: LiveData<String> get() = _messageLiveData

    fun sendAnswer(question: String) {
        viewModelScope.launch {
            _messageLiveData.value =
                    mServiceApi.getAnswers(Answers().apply {
                        this.question = question
                    }).answer
        }
    }

}
