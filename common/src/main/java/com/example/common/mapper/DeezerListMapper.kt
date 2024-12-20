package com.example.common.mapper

/**
 * Interface for mapping a list of input objects of type [I] to a list of output objects of type [O].
 *
 * This interface extends the generic `DeezerMapper` interface to specifically handle mappings 
 * between lists of objects, providing a structure for transforming collections of data from one
 * type to another. It is particularly useful when dealing with lists of data entities or DTOs
 * (Data Transfer Objects) that need to be converted for use in different layers of the application.
 *
 * @param I The type of input objects in the list.
 * @param O The type of output objects in the list.
 */
interface DeezerListMapper<I, O> : DeezerMapper<List<I>, List<O>>