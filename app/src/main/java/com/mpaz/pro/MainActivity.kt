package com.mpaz.pro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mpaz.pro.navigation.AppNavigation
import com.mpaz.pro.ui.theme.MpazProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MpazProTheme {
                AppNavigation()
            }
        }
    }
}
