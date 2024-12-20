package com.example.data.di.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * **CoroutineDispatchersModule**  
 * A Dagger module responsible for providing Coroutine Dispatcher dependencies.
 * This module integrates Coroutine dispatchers into the dependency injection framework, ensuring that
 * they are easily accessible and consistent throughout the application.
 */
@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatchersModule {

    /**
     * Provides the `Dispatchers.IO` Coroutine Dispatcher for I/O-bound tasks.
     *
     * The `Dispatchers.IO` is optimized for offloading blocking I/O operations to a shared thread pool.
     * Common use cases include file reading/writing, network calls, and database operations.
     *
     * The provided dispatcher is annotated with `@IoDispatcher` for differentiating it from other
     * dispatchers during dependency injection.
     *
     * @return The Coroutine I/O Dispatcher.
     *
     * Example Usage:
     * ```kotlin
     * @Inject
     * @IoDispatcher
     * lateinit var ioDispatcher: CoroutineDispatcher
     * 
     * lifecycleScope.launch(ioDispatcher) {
     *     // Perform I/O operations
     * }
     * ```
     */
    @IoDispatcher
    @Provides
    @Singleton
    fun providesIoDispatcher() = Dispatchers.IO
}
