package com.example.ktmovies.rest.impl

import com.example.ktmovies.domain.Answers
import com.example.ktmovies.rest.repository.ChatRepository
import com.example.ktmovies.rest.retrofit_service.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by danilorangel on 15/07/18.
 */
class ChatRepositoryImpl

@Inject
constructor(private val mServiceApi: ServiceApi) : ChatRepository {

    override suspend fun getAnswers(answers: Answers) = withContext(Dispatchers.IO) {
        mServiceApi.getAnwsers(answers)
    }

}