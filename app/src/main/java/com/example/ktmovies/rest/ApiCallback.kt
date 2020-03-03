package com.example.ktmovies.rest
//
//import com.example.ktmovies.domain.ERROR
//import retrofit2.Call
//import retrofit2.Response
//
///**
// * Created by danilorangel on 14/07/18.
// */
//abstract class ApiCallback<T> : retrofit2.Callback<T> {
//
//    abstract fun onSuccess(response: T?)
//
//    abstract fun onError(error: ApiError)
//
//    override fun onResponse(call: Call<T>, response: Response<T>) {
//        if (response.isSuccessful) {
//            onSuccess(response.body())
//        } else {
//            setGenericError()
//        }
//    }
//
//    override fun onFailure(call: Call<T>, t: Throwable) {
//        setError()
//    }
//
//    private fun setError() {
//        val error = ApiError(500, ERROR.GENERIC_500_MESSAGE)
//        onError(error)
//    }
//
//    private fun setGenericError() {
//        val error = ApiError(500, ERROR.GENERIC_ERROR)
//        onError(error)
//    }
//}