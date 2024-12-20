package com.example.common.extension

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Extension function to load an image from a URL into an ImageView using the Glide library.
 *
 * This function simplifies the process of asynchronously loading an image from a given URL
 * into an `ImageView`. It also includes a placeholder that displays a circular progress
 * indicator while the image is being loaded.
 *
 * @receiver ImageView - The ImageView into which the image will be loaded.
 * @param url String? - The URL of the image to load. If the URL is null, no image will be loaded.
 *
 * Example Usage:
 * ```kotlin
 * imageView.downloadFromUrl("https://example.com/image.jpg")
 * ```
 */
fun ImageView.downloadFromUrl(url: String?) {
    // Define request options with a placeholder to show while the image is loading.
    val options = RequestOptions()
        .placeholder(placeholderProgressBar(this.context)) // Circular progress bar as a placeholder.

    // Use Glide to load the image from the provided URL into this ImageView.
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

/**
 * Creates a `CircularProgressDrawable` to serve as a placeholder during image loading.
 *
 * This function creates a circular progress indicator with custom stroke width and radius
 * to enhance the user experience by providing a visual cue while the image loads.
 *
 * @param context Context - The context required to initialize the CircularProgressDrawable.
 * @return CircularProgressDrawable - A customized progress indicator.
 *
 * Example Usage:
 * ```kotlin
 * val progressDrawable = placeholderProgressBar(context)
 * ```
 */
fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    // Create and configure a CircularProgressDrawable.
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f // Set the thickness of the circular stroke.
        centerRadius = 40f // Set the radius of the progress circle.
        start() // Start the animation for the progress indicator.
    }
}
