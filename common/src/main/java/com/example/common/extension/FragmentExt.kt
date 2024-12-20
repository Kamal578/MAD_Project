package com.example.common.extension

import androidx.fragment.app.Fragment

/**
 * Retrieves the parent of the current fragment, either a parent fragment or the hosting activity,
 * if it matches the specified type [T].
 *
 * This function uses Kotlin's reified type parameter to check and cast the parent fragment or 
 * activity to the specified type [T]. It provides a convenient way to access the parent while 
 * ensuring type safety.
 *
 * @receiver Fragment - The current fragment instance calling this extension function.
 * @return T? - Returns the parent fragment or activity of type [T], or null if no parent matches 
 *         the specified type or if there is no parent at all.
 *
 * Example Usage:
 * ```kotlin
 * val parentActivity: MainActivity? = currentFragment.getParent<MainActivity>()
 * val parentFragment: ParentFragment? = currentFragment.getParent<ParentFragment>()
 * ```
 */
inline fun <reified T> Fragment.getParent(): T? {
    // Attempt to retrieve the parent fragment.
    val parentFragment = this.parentFragment

    // Check if the parent fragment exists and is of the specified type [T].
    if (parentFragment != null && parentFragment is T) {
        return parentFragment
    } else {
        // If no suitable parent fragment is found, check the hosting activity.
        val activity = this.activity
        if (activity != null && activity is T) {
            return activity
        }
    }
    // Return null if neither the parent fragment nor the activity matches the specified type [T].
    return null
}
