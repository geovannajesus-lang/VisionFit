package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

/**
 * ObstacleEntity - Entidade de obstáculo no banco de dados
 *
 * Registra obstáculos detectados durante a navegação
 * para alertar usuários futuros.
 *
 * @param id Identificador único do obstáculo (Firebase UID)
 * @param gymId ID da academia
 * @param latitude Latitude da localização
 * @param longitude Longitude da localização
 * @param floor Andar onde está localizado
 * @param type Tipo de obstáculo (ex: "piso molhado", "degrau", "objeto")
 * @param description Descrição do obstáculo
 * @param severity Severidade (LOW, MEDIUM, HIGH)
 * @param createdAt Data de detecção
 * @param updatedAt Data da última atualização
 * @param isResolved Se o obstáculo foi removido/resolvido
 *
 * @author VisionFit Team
 */
@Entity(
    tableName = "obstacles",
    foreignKeys = [
        ForeignKey(
            entity = GymEntity::class,
            parentColumns = ["id"],
            childColumns = ["gymId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ObstacleEntity(
    @PrimaryKey
    val id: String,
    val gymId: String,
    val latitude: Double,
    val longitude: Double,
    val floor: Int = 0,
    val type: String,
    val description: String,
    val severity: String, // LOW, MEDIUM, HIGH
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isResolved: Boolean = false
)