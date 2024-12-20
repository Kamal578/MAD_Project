package com.example.data.di.coroutine

import javax.inject.Qualifier

/**
 * **IoDispatcher**  
 * A custom qualifier annotation used to differentiate the Coroutine I/O dispatcher
 * during dependency injection.  
 *
 * This annotation helps Dagger or Hilt distinguish the `Dispatchers.IO` dispatcher
 * from other Coroutine dispatchers (e.g., `Dispatchers.Main` or `Dispatchers.Default`)
 * when injecting dependencies.
 *
 * Usage:
 * - Annotate dependencies that specifically provide or consume the I/O dispatcher with `@IoDispatcher`.
 * - This ensures clear and unambiguous injection of the appropriate dispatcher.
 *
 * Example Usage:
 * ```kotlin
 * @Module
 * @InstallIn(SingletonComponent::class)
 * object CoroutineDispatchersModule {
 *     @IoDispatcher
 *     @Provides
 *     @Singleton
 *     fun provideIoDispatcher() = Dispatchers.IO
 * }
 * 
 * class SomeRepository @Inject constructor(
 *     @IoDispatcher private val ioDispatcher: CoroutineDispatcher
 * ) {
 *     suspend fun fetchData() {
 *         withContext(ioDispatcher) {
 *             // Perform I/O operation
 *         }
 *     }
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher
