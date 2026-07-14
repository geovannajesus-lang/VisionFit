package com.visionfit.app.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkMode
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * VisionFitTheme - Tema Material 3 para a aplicação VisionFit
 *
 * Define:
 * - Cores do tema claro e escuro
 * - Tipografia
 * - Formas
 * - Padrões de acessibilidade
 *
 * @param darkTheme Se o tema escuro deve ser usado
 * @param dynamicColor Se cores dinâmicas devem ser usadas (Android 12+)
 * @param content Conteúdo composable a ser renderizado
 *
 * @author VisionFit Team
 */

// Esquema de cores claro
private val LightColorScheme = lightColorScheme(
    primary = DarkBlue,
    onPrimary = White,
    primaryContainer = LightBlue,
    onPrimaryContainer = DarkBlue,
    secondary = LightBlue,
    onSecondary = White,
    secondaryContainer = LightBlue.copy(alpha = 0.2f),
    onSecondaryContainer = DarkBlue,
    tertiary = Info,
    onTertiary = White,
    background = White,
    onBackground = DarkGray,
    surface = LightGray,
    onSurface = DarkGray,
    error = Error,
    onError = White,
    errorContainer = Error.copy(alpha = 0.1f),
    onErrorContainer = Error
)

// Esquema de cores escuro
private val DarkColorScheme = darkColorScheme(
    primary = LightBlue,
    onPrimary = DarkBlue,
    primaryContainer = DarkBlue,
    onPrimaryContainer = LightBlue,
    secondary = LightBlue,
    onSecondary = DarkBlue,
    secondaryContainer = LightBlue.copy(alpha = 0.3f),
    onSecondaryContainer = LightBlue,
    tertiary = Info,
    onTertiary = DarkBlue,
    background = DarkBlue,
    onBackground = White,
    surface = DarkGray,
    onSurface = White,
    error = Error,
    onError = DarkBlue,
    errorContainer = Error.copy(alpha = 0.2f),
    onErrorContainer = Error.copy(alpha = 0.9f)
)

@Composable
fun VisionFitTheme(
    darkTheme: Boolean = isSystemInDarkMode(),
    dynamicColor: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = VisionFitTypography,
        content = content
    )
}