package com.example.splashscreen

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        splashScreen.setOnExitAnimationListener { splashScreenView ->

            val scaleX = ObjectAnimator.ofFloat(splashScreenView.iconView, "scaleX", 1f, 3f)
            val scaleY = ObjectAnimator.ofFloat(splashScreenView.iconView, "scaleY", 1f, 3f)
            val fadeOut = ObjectAnimator.ofFloat(splashScreenView.iconView, "alpha", 1f, 0f)

            scaleX.duration = 300
            scaleY.duration = 300
            fadeOut.duration = 300

            scaleX.interpolator = AccelerateDecelerateInterpolator()
            scaleY.interpolator = AccelerateDecelerateInterpolator()
            fadeOut.interpolator = AccelerateDecelerateInterpolator()

            scaleX.start()
            scaleY.start()
            fadeOut.start()

            fadeOut.doOnEnd {
                splashScreenView.remove()
            }
        }

        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "¡Splash Screen terminado, Bienvenido!",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }
            }
        }
    }
}
