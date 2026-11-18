
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
// COMMERZO — MATERIAL 3 COLOR SYSTEM
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
    onTertiary = CommerzoBlack,
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

// ============================================================
// DARK COLOR SCHEME
// ============================================================

private val DarkColors = darkColorScheme(
    primary = CommerzoPrimaryDark,
    onPrimary = CommerzoBlack,
    primaryContainer = CommerzoDarkPrimaryContainer,
    onPrimaryContainer = CommerzoDarkOnPrimaryContainer,

    secondary = CommerzoSecondary,
    onSecondary = CommerzoBlack,
    secondaryContainer = CommerzoDarkSecondaryContainer,
    onSecondaryContainer = CommerzoDarkOnSecondaryContainer,

    tertiary = CommerzoTertiary,
    onTertiary = CommerzoBlack,
    tertiaryContainer = CommerzoDarkTertiaryContainer,
    onTertiaryContainer = CommerzoDarkOnTertiaryContainer,

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
    errorContainer = CommerzoDarkErrorContainer,
    onErrorContainer = CommerzoDarkOnErrorContainer
)

// ============================================================
// CENTRALIZED SHAPE SYSTEM
// ============================================================

private val CommerzoShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(30.dp)
)

// ============================================================
// ROOT THEME
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
