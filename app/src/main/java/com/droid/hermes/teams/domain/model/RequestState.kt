package com.droid.hermes.teams.domain.model

/**
 * Created on 19/07/20.
 */
sealed class RequestState<T> {

    class Started<T> : RequestState<T>()

    class NetworkError<T> : RequestState<T>()

    data class Success<T>(val data: T) : RequestState<T>()

    data class ServerError<T>(val errocCode: Int, val message: String) : RequestState<T>()

}