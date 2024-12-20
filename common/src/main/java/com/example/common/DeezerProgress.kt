package com.example.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.common.databinding.DeezerProgressBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A custom progress dialog implementation using DialogFragment.
 *
 * The `DeezerProgress` class displays a non-cancelable dialog with a transparent background
 * that can be used as a loading indicator in the application. The dialog is designed to rotate
 * an image or perform other visual feedback, indicating ongoing processes.
 */
class DeezerProgress : DialogFragment() {

    // ViewBinding instance for accessing views in the layout.
    private var _binding: DeezerProgressBinding? = null

    // Non-nullable binding to safely access the layout views.
    private val binding get() = _binding!!

    /**
     * Inflates the dialog's layout and configures the dialog's appearance.
     *
     * The dialog has no title, is non-cancelable, and uses a transparent background.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using ViewBinding.
        _binding = DeezerProgressBinding.inflate(inflater, container, false)

        // Remove the dialog's title.
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Make the dialog non-cancelable.
        dialog?.setCancelable(false)

        // Set a transparent background for the dialog.
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Return the root view of the binding.
        return binding.root
    }

    /**
     * Initializes and starts the loading animation when the view is created.
     *
     * A coroutine runs indefinitely, updating the rotation of the loading icon to simulate a spinner effect.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Launch a coroutine in the lifecycleScope to handle the rotation animation.
        lifecycleScope.launch {
            while (true) {
                // Introduce a delay to create a smooth animation effect.
                delay(50L)

                // Update the UI on the main thread.
                withContext(Dispatchers.Main) {
                    // Uncomment the below line to enable rotation animation.
                    // binding.icLoading.rotation = binding.icLoading.rotation + 10
                }
            }
        }
    }

    /**
     * Cleans up resources when the dialog is destroyed.
     *
     * Ensures the ViewBinding instance is set to null to avoid memory leaks.
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
