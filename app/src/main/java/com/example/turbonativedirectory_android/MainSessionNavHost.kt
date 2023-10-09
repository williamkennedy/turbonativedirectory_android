package com.example.turbonativedirectory_android

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.turbonativedirectory_android.fragments.WebFragment
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

const val ROOT_URL = "https://turbonative.directory"

class MainSessionNavHost : TurboSessionNavHostFragment() {
    override val sessionName = "main"
    override val startLocation = ROOT_URL

    override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
            WebFragment::class
        )

    override val registeredActivities: List<KClass<out AppCompatActivity>>
        get() = listOf()

    override val pathConfigurationLocation: TurboPathConfiguration.Location
        get() = TurboPathConfiguration.Location( assetFilePath = "json/path_configuration.json")

}