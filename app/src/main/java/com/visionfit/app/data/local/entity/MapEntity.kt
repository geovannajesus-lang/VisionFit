package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

/**
 * MapEntity - Entidade de mapa da academia no banco de dados
 *
 * Armazena informações do mapa interno de uma academia,
 * incluindo layout e pontos de referência.
 *
 * @param id Identificador único do mapa (Firebase UID)
 * @param gymId ID da academia
 * @param adminId ID do administrador que criou/editou
 * @param mapImageUrl URL da imagem do mapa
 * @param mapDataJson Dados do mapa em formato JSON
 * @param floor Andar do mapa
 * @param width Largura do mapa em metros
 * @param height Altura do mapa em metros
 * @param createdAt Data de criação
 * @param updatedAt Data da última atualização
 *
 * @author VisionFit Team
 */
@Entity(
    tableName = "maps",
    foreignKeys = [
        ForeignKey(
            entity = GymEntity::class,
            parentColumns = ["id"],
            childColumns = ["gymId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MapEntity(
    @PrimaryKey
    val id: String,
    val gymId: String,
    val adminId: String,
    val mapImageUrl: String?,
    val mapDataJson: String, // JSON com dados do mapa
    val floor: Int = 0,
    val width: Double, // em metros
    val height: Double, // em metros
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)