package com.visionfit.app.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.visionfit.app.data.local.dao.*
import com.visionfit.app.data.local.entity.*
import com.visionfit.app.data.local.converter.DateConverter

/**
 * VisionFitDatabase - Classe de configuração do Room Database
 *
 * Responsável por:
 * - Definir todas as entidades da aplicação
 * - Fornecer DAOs para acesso aos dados
 * - Gerenciar a criação e versão do banco de dados
 *
 * Entidades:
 * - UserEntity: Dados do usuário
 * - GymEntity: Dados das academias
 * - EquipmentEntity: Dados dos equipamentos
 * - TrainingEntity: Histórico de treinos
 * - RouteEntity: Rotas de navegação
 * - MapEntity: Mapas das academias
 * - ObstacleEntity: Obstáculos detectados
 *
 * @author VisionFit Team
 */
@Database(
    entities = [
        UserEntity::class,
        GymEntity::class,
        EquipmentEntity::class,
        TrainingEntity::class,
        RouteEntity::class,
        MapEntity::class,
        ObstacleEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class VisionFitDatabase : RoomDatabase() {

    // DAOs
    abstract fun userDao(): UserDao
    abstract fun gymDao(): GymDao
    abstract fun equipmentDao(): EquipmentDao
    abstract fun trainingDao(): TrainingDao
    abstract fun routeDao(): RouteDao
    abstract fun mapDao(): MapDao
    abstract fun obstacleDao(): ObstacleDao

    companion object {
        @Volatile
        private var INSTANCE: VisionFitDatabase? = null

        fun getDatabase(context: Context): VisionFitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VisionFitDatabase::class.java,
                    "visionfit_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}