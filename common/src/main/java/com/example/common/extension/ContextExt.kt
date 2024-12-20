package com.example.common.extension

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings
import android.widget.Toast

/**
 * Extension function to check if the device has an active internet connection.
 *
 * This function checks the device's current network state by using the ConnectivityManager
 * system service. It determines whether there is a network connection that has internet capabilities.
 *
 * @receiver Context - The context used to access system services.
 * @return Boolean - Returns true if the device has an active internet connection, false otherwise.
 */
fun Context.isNetworkAvailable(): Boolean {
    // Obtain the ConnectivityManager system service.
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    
    // Check if there is an active network connection. Return false if none exists.
    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    
    // Retrieve network capabilities of the active network.
    val capabilities =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

    // Check if the network has internet capability and return the result.
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

/**
 * Extension function to display a short Toast message.
 *
 * This function simplifies the process of showing a Toast message. It uses the provided
 * context to display a message on the screen.
 *
 * @receiver Context - The context in which the Toast should be displayed.
 * @param message String - The message to be displayed in the Toast.
 */
fun Context.toastMessage(message: String) {
    // Create and show a short-duration Toast with the specified message.
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Opens the device's internet settings with user confirmation.
 *
 * This function shows an AlertDialog asking the user if they want to navigate to the
 * device's internet settings. If the user confirms, it opens the Wi-Fi settings screen.
 * Otherwise, no action is taken.
 *
 * @receiver Context - The context used to show the dialog and start the settings activity.
 */
fun Context.navigateToInternetSettingsWithConfirmation() {
    // Create an AlertDialog.Builder instance with the current context.
    val builder = AlertDialog.Builder(this)

    // Set the title of the AlertDialog.
    builder.setTitle("Internet Settings")

    // Set the message that will be displayed in the AlertDialog.
    builder.setMessage("Do you want to open Internet settings?")

    // Define the positive button action (user selects "Yes").
    builder.setPositiveButton("Yes") { _, _ ->
        // Create an intent to open the Wi-Fi settings screen.
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        startActivity(intent)
    }

    // Define the negative button action (user selects "No"). No additional action is taken.
    builder.setNegativeButton("No", null)

    // Create and show the AlertDialog.
    builder.create().show()
}
