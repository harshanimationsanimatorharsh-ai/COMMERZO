package com.commerzo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.commerzo.app.navigation.AuthNavigation
import com.commerzo.app.ui.theme.CommerzoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CommerzoTheme {
                AuthNavigation()
            }
        }
    }
}
