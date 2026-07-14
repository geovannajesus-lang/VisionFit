package com.visionfit.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * VisionFitApplication - Classe de aplicação principal
 *
 * Responsável por:
 * - Inicializar Hilt para injeção de dependências
 * - Configurar Timber para logging
 * - Inicializar componentes globais
 *
 * @author VisionFit Team
 */
@HiltAndroidApp
class VisionFitApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inicializar Timber para logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Timber.d("VisionFit Application initialized")
    }
}