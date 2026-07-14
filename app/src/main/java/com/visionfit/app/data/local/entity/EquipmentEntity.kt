package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

/**
 * EquipmentEntity - Entidade de equipamento no banco de dados
 *
 * Representa um equipamento de academia com sua localização
 * e informações de navegação.
 *
 * @param id Identificador único do equipamento (Firebase UID)
 * @param gymId ID da academia a que pertence
 * @param name Nome do equipamento (ex: "Esteira 1", "Supino")
 * @param description Descrição do equipamento
 * @param category Categoria (ex: "Cardio", "Musculação")
 * @param latitude Latitude da localização no mapa
 * @param longitude Longitude da localização no mapa
 * @param floor Andar onde se localiza
 * @param zone Zona/Setor da academia
 * @param createdAt Data de criação
 * @param updatedAt Data da última atualização
 * @param isActive Se o equipamento está disponível
 *
 * @author VisionFit Team
 */
@Entity(
    tableName = "equipments",
    foreignKeys = [
        ForeignKey(
            entity = GymEntity::class,
            parentColumns = ["id"],
            childColumns = ["gymId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EquipmentEntity(
    @PrimaryKey
    val id: String,
    val gymId: String,
    val name: String,
    val description: String,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val floor: Int = 0,
    val zone: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isActive: Boolean = true
)