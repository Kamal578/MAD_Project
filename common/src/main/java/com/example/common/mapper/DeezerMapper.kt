package com.example.common.mapper

/**
 * A generic interface for mapping an object of type [I] (input) to an object of type [O] (output).
 *
 * The `DeezerMapper` interface is designed to provide a consistent approach for transforming
 * data between different layers or representations within an application. This is particularly
 * useful for adapting data entities, DTOs (Data Transfer Objects), or domain models.
 *
 * @param I The type of the input object.
 * @param O The type of the output object.
 */
interface DeezerMapper<I, O> {
    /**
     * Transforms an object of type [I] into an object of type [O].
     *
     * Implementers of this method define the logic for mapping one type to another. This enables
     * modular and reusable data transformation logic across the application.
     *
     * @param input The input object of type [I] to be mapped.
     * @return The transformed object of type [O].
     *
     * Example Implementation:
     * ```kotlin
     * class UserEntityToDomainMapper : DeezerMapper<UserEntity, UserDomain> {
     *     override fun map(input: UserEntity): UserDomain {
     *         return UserDomain(
     *             id = input.id,
     *             name = input.name,
     *             email = input.email
     *         )
     *     }
     * }
     * ```
     */
    fun map(input: I): O
}
