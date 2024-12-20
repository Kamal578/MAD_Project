package com.example.common

/**
 * A sealed interface representing the result of an operation, which can either be successful
 * or result in an error. This is useful for handling different outcomes of asynchronous or
 * synchronous operations in a type-safe way.
 *
 * @param T The type of the data result.
 */
sealed interface ResponseResult<out T> {

    /**
     * A data class representing a successful result with optional data.
     *
     * @param data The data result, which can be `null` if no data is returned.
     */
    data class Success<T>(val data: T?) : ResponseResult<T>

    /**
     * A sealed interface representing an error result with an associated error object.
     *
     * @param T The type of the data result.
     */
    sealed interface Error<T> : ResponseResult<T> {
        val error: ResultError

        /**
         * A data class representing an `IOException` error, typically for network-related issues.
         *
         * @param error The error object containing details about the error.
         */
        data class IOException<T>(override val error: ResultError) : Error<T>

        /**
         * A data class representing an `InternetUnavailableException`, indicating
         * that the internet connection is not available.
         *
         * @param error The error object containing details about the error.
         */
        data class InternetUnavailableException<T>(
            override val error: ResultError
        ) : Error<T>

        /**
         * A data class representing an API error, such as a failed request or unexpected response.
         *
         * @param error The error object containing details about the error.
         */
        data class ApiError<T>(override val error: ResultError) : Error<T>
    }
}

/**
 * Executes the provided [handler] function if the result is a success.
 *
 * @param handler A lambda function to handle the success case, which receives the data result.
 * @return The original `ResponseResult` for further chaining or inspection.
 *
 * Example Usage:
 * ```kotlin
 * responseResult.onSuccess { data ->
 *     println("Operation succeeded with data: $data")
 * }
 * ```
 */
inline fun <T> ResponseResult<T>.onSuccess(handler: (T?) -> Unit): ResponseResult<T> =
    this.also {
        if (this is ResponseResult.Success)
            handler(data)
    }

/**
 * Executes the provided [handler] function if the result is an error.
 *
 * @param handler A lambda function to handle the error case, which receives the error object.
 * @return The original `ResponseResult` for further chaining or inspection.
 *
 * Example Usage:
 * ```kotlin
 * responseResult.onError { error ->
 *     println("Operation failed with error: ${error?.error}")
 * }
 * ```
 */
inline fun <T> ResponseResult<T>.onError(handler: (ResponseResult.Error<T>?) -> Unit): ResponseResult<T> =
    this.also {
        if (this is ResponseResult.Error)
            handler(this)
    }

/**
 * A data class representing an error object, encapsulating the details of an error.
 *
 * @param errorMessage A descriptive message providing details about the error. Can be `null`.
 * @param errorCode An optional error code that categorizes the error. Can be `null`.
 *
 * Example Usage:
 * ```kotlin
 * val error = ResultError("Network error", 404)
 * println("Error: ${error.errorMessage}, Code: ${error.errorCode}")
 * ```
 */
data class ResultError(val errorMessage: String?, val errorCode: Int? = null)
