package com.visionfit.app.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * FirebaseModule - Módulo Hilt para injeção de dependências do Firebase
 *
 * Fornece singletons para:
 * - FirebaseAuth
 * - FirebaseFirestore
 *
 * @author VisionFit Team
 */
@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    /**
     * Fornece instância única do FirebaseAuth
     *
     * @return Instância do Firebase Authentication
     */
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    /**
     * Fornece instância única do FirebaseFirestore
     *
     * @return Instância do Firebase Firestore
     */
    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}