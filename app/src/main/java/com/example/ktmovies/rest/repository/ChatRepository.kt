package com.example.ktmovies.rest.repository

import com.example.ktmovies.domain.Answers

//import com.example.ktmovies.domain.Answers
//import com.example.ktmovies.rest.Callback

/**
 * Created by danilorangel on 14/07/18.
 */
interface ChatRepository {

    suspend fun getAnswers(answers: Answers): Answers
}