package com.app.nervous.rest.retrofit_service

import com.app.nervous.domain.Answers
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by danilorangel on 7/14/18.
 */
interface ServiceApi {

    @POST("api/answer")
    suspend fun getAnwsers(@Body answer: Answers): Answers
}
