package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

/**
 * TrainingEntity - Entidade de histórico de treino no banco de dados
 *
 * Registra uma sessão de treino do usuário com informações
 * de duração, equipamentos utilizados e métricas.
 *
 * @param id Identificador único do treino (Firebase UID)
 * @param userId ID do usuário
 * @param gymId ID da academia
 * @param equipmentId ID do equipamento utilizado
 * @param duration Duração do treino em minutos
 * @param caloriesBurned Calorias queimadas (estimado)
 * @param distance Distância percorrida em metros
 * @param startTime Data e hora do início
 * @param endTime Data e hora do término
 * @param notes Observações do treino
 * @param createdAt Data de registro
 *
 * @author VisionFit Team
 */
@Entity(
    tableName = "trainings",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = GymEntity::class,
            parentColumns = ["id"],
            childColumns = ["gymId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EquipmentEntity::class,
            parentColumns = ["id"],
            childColumns = ["equipmentId"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class TrainingEntity(
    @PrimaryKey
    val id: String,
    val userId: String,
    val gymId: String,
    val equipmentId: String?,
    val duration: Int, // em minutos
    val caloriesBurned: Double,
    val distance: Double, // em metros
    val startTime: Date,
    val endTime: Date,
    val notes: String? = null,
    val createdAt: Date = Date()
)