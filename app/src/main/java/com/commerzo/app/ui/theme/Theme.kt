package com.commerzo.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

// ============================================================
// COMMERZO — Professional Material 3 Theme
// Phase 7 — Professional Design System
// ============================================================

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
    primaryContainer = CommerzoPrimaryContainer,
    onPrimaryContainer = CommerzoOnPrimaryContainer,

    secondary = CommerzoSecondary,
    onSecondary = CommerzoBlack,
    secondaryContainer = CommerzoDarkSurfaceVariant,
    onSecondaryContainer = CommerzoSecondary,

    tertiary = CommerzoTertiary,
    onTertiary = CommerzoBlack,
    tertiaryContainer = CommerzoTertiaryContainer,
    onTertiaryContainer = CommerzoTertiary,

    background = CommerzoDarkBackground,
    onBackground = CommerzoDarkOnBackground,

    surface = CommerzoDarkSurface,
    onSurface = CommerzoDarkOnSurface,

    surfaceVariant = CommerzoDarkSurfaceVariant,
    onSurfaceVariant = CommerzoDarkOnSurfaceVariant,

    outline = CommerzoDarkOutline,
    outlineVariant = CommerzoDarkOutline,

    error = CommerzoError,
    onError = CommerzoWhite,
    errorContainer = CommerzoErrorContainer,
    onErrorContainer = CommerzoOnErrorContainer
)

// ============================================================
// Centralized Shape System
// ============================================================

private val CommerzoShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(30.dp)
)

// ============================================================
// Root Theme
// ============================================================

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
