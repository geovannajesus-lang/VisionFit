package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * GymEntity - Entidade de academia no banco de dados
 *
 * Representa uma academia cadastrada na aplicação com suas informações
 * de localização e configuração.
 *
 * @param id Identificador único da academia (Firebase UID)
 * @param adminId ID do usuário administrador
 * @param name Nome da academia
 * @param description Descrição da academia
 * @param address Endereço completo
 * @param latitude Latitude da localização
 * @param longitude Longitude da localização
 * @param mapUrl URL do mapa interno (Google Maps Indoor)
 * @param createdAt Data de criação
 * @param updatedAt Data da última atualização
 * @param isActive Se a academia está ativa
 *
 * @author VisionFit Team
 */
@Entity(tableName = "gyms")
data class GymEntity(
    @PrimaryKey
    val id: String,
    val adminId: String,
    val name: String,
    val description: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val mapUrl: String? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isActive: Boolean = true
)