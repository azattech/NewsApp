package com.example.newsapp.base


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 17/05/2020 - 3:25 PM  *
 ************************/
sealed class Output<out T : Any> {
    data class Success<out T : Any>(val output: T) : Output<T>()
    data class Error(val exception: Exception) : Output<Nothing>()
}

sealed class State<T> {
    class Loading<T> : State<T>()
    data class Success<T>(val data: T) : State<T>()
    data class Failed<T>(val message: String) : State<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failed<T>(message)
    }

    // https://medium.com/firebase-developers/firebase-ing-with-kotlin-coroutines-flow-dab1bc364816

}