package com.visionfit.app.di

import android.content.Context
import androidx.room.Room
import com.visionfit.app.data.local.database.VisionFitDatabase
import com.visionfit.app.data.local.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DatabaseModule - Módulo Hilt para injeção de dependências do banco de dados
 *
 * Fornece singletons para:
 * - VisionFitDatabase
 * - Todos os DAOs
 *
 * @author VisionFit Team
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Fornece instância única do VisionFitDatabase
     *
     * @param context Contexto da aplicação
     * @return Instância do banco de dados
     */
    @Provides
    @Singleton
    fun provideVisionFitDatabase(
        @ApplicationContext context: Context
    ): VisionFitDatabase {
        return Room.databaseBuilder(
            context,
            VisionFitDatabase::class.java,
            "visionfit_database"
        ).build()
    }

    /**
     * Fornece instância do UserDao
     */
    @Provides
    @Singleton
    fun provideUserDao(database: VisionFitDatabase): UserDao {
        return database.userDao()
    }

    /**
     * Fornece instância do GymDao
     */
    @Provides
    @Singleton
    fun provideGymDao(database: VisionFitDatabase): GymDao {
        return database.gymDao()
    }

    /**
     * Fornece instância do EquipmentDao
     */
    @Provides
    @Singleton
    fun provideEquipmentDao(database: VisionFitDatabase): EquipmentDao {
        return database.equipmentDao()
    }

    /**
     * Fornece instância do TrainingDao
     */
    @Provides
    @Singleton
    fun provideTrainingDao(database: VisionFitDatabase): TrainingDao {
        return database.trainingDao()
    }

    /**
     * Fornece instância do RouteDao
     */
    @Provides
    @Singleton
    fun provideRouteDao(database: VisionFitDatabase): RouteDao {
        return database.routeDao()
    }

    /**
     * Fornece instância do MapDao
     */
    @Provides
    @Singleton
    fun provideMapDao(database: VisionFitDatabase): MapDao {
        return database.mapDao()
    }

    /**
     * Fornece instância do ObstacleDao
     */
    @Provides
    @Singleton
    fun provideObstacleDao(database: VisionFitDatabase): ObstacleDao {
        return database.obstacleDao()
    }
}