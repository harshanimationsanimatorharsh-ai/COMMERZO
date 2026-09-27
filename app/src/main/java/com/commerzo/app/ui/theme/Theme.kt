package com.commerzo.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = CommerzoPrimary,
    onPrimary = CommerzoWhite,
    primaryContainer = CommerzoPrimaryContainer,
    onPrimaryContainer = CommerzoOnPrimaryContainer,

    secondary = CommerzoSecondary,
    onSecondary = CommerzoWhite,
    secondaryContainer = CommerzoSecondaryContainer,
    onSecondaryContainer = CommerzoOnSecondaryContainer,

    tertiary = CommerzoTertiary,
    onTertiary = CommerzoWhite,
    tertiaryContainer = CommerzoTertiaryContainer,
    onTertiaryContainer = CommerzoOnTertiaryContainer,

    background = CommerzoBackground,
    onBackground = CommerzoOnBackground,

    surface = CommerzoSurface,
    onSurface = CommerzoOnSurface,
    surfaceVariant = CommerzoSurfaceVariant,
    onSurfaceVariant = CommerzoOnSurfaceVariant,

    outline = CommerzoOutline,
    outlineVariant = CommerzoOutlineVariant,

    error = CommerzoError,
    onError = CommerzoWhite,
    errorContainer = CommerzoErrorContainer,
    onErrorContainer = CommerzoOnErrorContainer
)

private val DarkColors = darkColorScheme(
    primary = CommerzoPrimaryDark,
    onPrimary = CommerzoBlack,
    primaryContainer = CommerzoOnPrimaryContainer,
    onPrimaryContainer = CommerzoPrimaryContainer,

    secondary = CommerzoSecondary,
    onSecondary = CommerzoBlack,
    secondaryContainer = CommerzoSecondaryContainer,
    onSecondaryContainer = CommerzoSecondary,

    tertiary = CommerzoTertiary,
    onTertiary = CommerzoWhite,
    tertiaryContainer = CommerzoTertiaryContainer,
    onTertiaryContainer = CommerzoTertiary,

    background = CommerzoDarkBackground,
    onBackground = CommerzoDarkOnBackground,

    surface = CommerzoDarkSurface,
    onSurface = CommerzoDarkOnSurface,
    surfaceVariant = CommerzoDarkSurfaceVariant,
    onSurfaceVariant = CommerzoDarkOnSurfaceVariant,

    outline = CommerzoDarkOutline,
    outlineVariant = CommerzoDarkOutlineVariant,

    error = CommerzoError,
    onError = CommerzoWhite,
    errorContainer = CommerzoErrorContainer,
    onErrorContainer = CommerzoError
)

private val CommerzoShapes = Shapes(
    extraSmall = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
    small = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
    medium = androidx.compose.foundation.shape.RoundedCornerShape(18.dp),
    large = androidx.compose.foundation.shape.RoundedCornerShape(24.dp),
    extraLarge = androidx.compose.foundation.shape.RoundedCornerShape(30.dp)
)

@Composable
fun CommerzoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = CommerzoTypography,
        shapes = CommerzoShapes,
        content = content
    )
}
