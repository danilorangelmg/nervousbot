package com.app.nervous.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.nervous.domain.Answers
import com.app.nervous.rest.repository.ChatRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by danilorangel on 14/07/18.
 */

class ChatViewModel
@Inject
constructor(private val mServiceApi: ChatRepository) : ViewModel() {

    val answersLivedata: LiveData<String> get() = _answersLivedata

    private val _answersLivedata = MutableLiveData<String>()

    fun getAnswers(question: String) {
        viewModelScope.launch {
            mServiceApi.getAnswers(Answers().apply { this.question = question }).collect {
                _answersLivedata.value = it.answer
            }
        }
    }
}
