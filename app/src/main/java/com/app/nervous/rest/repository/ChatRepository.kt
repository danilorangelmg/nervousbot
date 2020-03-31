package com.app.nervous.rest.repository

import com.app.nervous.domain.Answers
import kotlinx.coroutines.flow.Flow

/**
 * Created by danilorangel on 14/07/18.
 */
interface ChatRepository {

    suspend fun getAnswers(answers: Answers): Flow<Answers>
}