package com.app.nervous.rest.impl

import com.app.nervous.domain.Answers
import com.app.nervous.rest.repository.ChatRepository
import com.app.nervous.rest.retrofit_service.ServiceApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by danilorangel on 15/07/18.
 */
class ChatRepositoryImpl

@Inject
constructor(private val mServiceApi: ServiceApi) : ChatRepository {

    override suspend fun getAnswers(answers: Answers) = flow {
        emit(mServiceApi.getAnwsers(answers))
    }

}