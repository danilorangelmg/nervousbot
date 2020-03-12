package com.example.ktmovies.rest.repository

import com.example.ktmovies.domain.Answers

/**
 * Created by danilorangel on 14/07/18.
 */
interface ChatRepository {

    suspend fun getAnswers(answers: Answers): Answers
}