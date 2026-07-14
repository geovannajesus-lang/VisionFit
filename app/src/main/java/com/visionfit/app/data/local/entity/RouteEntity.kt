package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

/**
 * RouteEntity - Entidade de rota de navegação no banco de dados
 *
 * Representa uma rota de navegação entre dois pontos
 * dentro de uma academia.
 *
 * @param id Identificador único da rota (Firebase UID)
 * @param trainingId ID do treino associado
 * @param startLatitude Latitude do ponto de início
 * @param startLongitude Longitude do ponto de início
 * @param endLatitude Latitude do ponto de destino
 * @param endLongitude Longitude do ponto de destino
 * @param distance Distância total em metros
 * @param estimatedTime Tempo estimado em minutos
 * @param waypoints String JSON com pontos intermediários
 * @param isCompleted Se a rota foi concluída
 * @param createdAt Data de criação
 * @param completedAt Data de conclusão
 *
 * @author VisionFit Team
 */
@Entity(
    tableName = "routes",
    foreignKeys = [
        ForeignKey(
            entity = TrainingEntity::class,
            parentColumns = ["id"],
            childColumns = ["trainingId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RouteEntity(
    @PrimaryKey
    val id: String,
    val trainingId: String,
    val startLatitude: Double,
    val startLongitude: Double,
    val endLatitude: Double,
    val endLongitude: Double,
    val distance: Double, // em metros
    val estimatedTime: Int, // em minutos
    val waypoints: String, // JSON
    val isCompleted: Boolean = false,
    val createdAt: Date = Date(),
    val completedAt: Date? = null
)