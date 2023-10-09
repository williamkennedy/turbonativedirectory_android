package com.example.turbonativedirectory_android.fragments

import android.content.Intent
import android.net.Uri
import com.example.turbonativedirectory_android.ROOT_URL
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavDestination
import dev.hotwire.turbo.nav.TurboNavGraphDestination



@TurboNavGraphDestination(uri = "turbo://fragment/web")
class WebFragment : TurboWebFragment(), TurboNavDestination {

    override fun shouldNavigateTo(newLocation: String): Boolean {
        return when (newLocation.startsWith(ROOT_URL)) {
            true -> {
                true
            }
            else -> {
                launchBrowser(newLocation)
                false
            }
        }
    }

    private fun launchBrowser(location: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
        context?.startActivity((intent))
    }
}