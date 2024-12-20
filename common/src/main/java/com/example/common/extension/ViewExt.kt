package com.example.common.extension

import android.view.View

/**
 * Extension function to set the visibility of a View to `VISIBLE`.
 *
 * This function makes the view visible on the screen, allowing it to take up space
 * in the layout and be rendered to the user.
 *
 * @receiver View - The view whose visibility will be changed.
 *
 * Example Usage:
 * ```kotlin
 * view.visible() // Sets the view's visibility to View.VISIBLE
 * ```
 */
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * Extension function to set the visibility of a View to `GONE`.
 *
 * This function hides the view from the screen and removes it from the layout,
 * ensuring that it does not take up any space in the layout.
 *
 * @receiver View - The view whose visibility will be changed.
 *
 * Example Usage:
 * ```kotlin
 * view.gone() // Sets the view's visibility to View.GONE
 * ```
 */
fun View.gone() {
    visibility = View.GONE
}
