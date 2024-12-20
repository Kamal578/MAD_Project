package com.example.data.util

import com.example.common.ResponseResult
import com.example.common.mapper.DeezerMapper

/**
 * **toDomain Extension Function**  
 * Converts a `ResponseResult` from the data layer to a domain-specific `ResponseResult` using a provided mapper.  
 * This extension function allows seamless transformation of data while maintaining clean architecture.
 *
 * @param T The type of the data in the original `ResponseResult`.
 * @param D The type of the data in the domain-specific `ResponseResult`.
 * @param mapper The `DeezerMapper` instance used to map data from type `T` to type `D`.
 * @return A domain-specific `ResponseResult` containing either the mapped success data or the original error.
 */
internal fun <T, D> ResponseResult<T>.toDomain(mapper: DeezerMapper<T, D>): ResponseResult<D> {
    return when (this) {
        is ResponseResult.Success -> toDomain(mapper) // Map success data using the provided mapper.
        is ResponseResult.Error -> toDomain() // Convert the error type without modification.
    }
}

/**
 * **toDomain (Error Handling)**  
 * Converts a `ResponseResult.Error` to a domain-specific `ResponseResult.Error`.  
 * This ensures errors are propagated through the application layers without altering the error details.
 *
 * @return A domain-specific `ResponseResult.Error` with the same error details as the original.
 */
private fun <T, D> ResponseResult.Error<T>.toDomain(): ResponseResult.Error<D> {
    return when (this) {
        is ResponseResult.Error.IOException -> ResponseResult.Error.IOException<D>(this.error)
        is ResponseResult.Error.InternetUnavailableException -> ResponseResult.Error.InternetUnavailableException<D>(this.error)
        is ResponseResult.Error.ApiError -> ResponseResult.Error.ApiError<D>(this.error)
    }
}

/**
 * **toDomain (Success Handling)**  
 * Converts a `ResponseResult.Success` to a domain-specific `ResponseResult.Success` using the provided mapper.  
 * The mapper is used to transform the data from one type to another while keeping the success status intact.
 *
 * @param T The type of the data in the original `ResponseResult.Success`.
 * @param D The type of the data in the domain-specific `ResponseResult.Success`.
 * @param mapper The `DeezerMapper` used to map data from type `T` to type `D`.
 * @return A domain-specific `ResponseResult.Success` containing the mapped data.
 */
private fun <T, D> ResponseResult.Success<T>.toDomain(mapper: DeezerMapper<T, D>): ResponseResult.Success<D> {
    return ResponseResult.Success<D>(data = mapper.map(this.data!!)) // Transform the data using the mapper.
}
