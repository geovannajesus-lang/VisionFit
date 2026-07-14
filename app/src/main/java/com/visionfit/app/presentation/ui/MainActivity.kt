package com.visionfit.app.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.visionfit.app.presentation.navigation.RootNavigation
import com.visionfit.app.presentation.theme.VisionFitTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity - Atividade principal da aplicação VisionFit
 *
 * Responsável por:
 * - Configurar o tema da aplicação
 * - Inicializar o sistema de navegação
 * - Gerenciar o ciclo de vida da aplicação
 *
 * @author VisionFit Team
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisionFitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavigation()
                }
            }
        }
    }
}