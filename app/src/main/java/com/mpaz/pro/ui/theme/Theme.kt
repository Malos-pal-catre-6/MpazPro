package com.mpaz.pro.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val Colores = lightColorScheme(
    primary = AzulMpaz,
    onPrimary = FondoSuave,
    primaryContainer = AzulClaro,
    onPrimaryContainer = TextoOscuro,
    secondary = VerdeMpaz,
    background = FondoSuave,
    onBackground = TextoOscuro,
    surface = FondoSuave,
    onSurface = TextoOscuro,
    error = RojoError
)

@Composable
fun MpazProTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = Colores,
        content = content
    )
}
