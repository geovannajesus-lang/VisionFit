package com.visionfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * UserEntity - Entidade de usuário no banco de dados
 *
 * Representa um usuário da aplicação VisionFit com suas informações básicas
 * e preferências de acessibilidade.
 *
 * @param id Identificador único do usuário (Firebase UID)
 * @param email Email do usuário
 * @param name Nome completo do usuário
 * @param profileImageUrl URL da foto de perfil
 * @param createdAt Data de criação da conta
 * @param updatedAt Data da última atualização
 * @param isAdmin Se o usuário é administrador
 * @param textSizeMultiplier Multiplicador do tamanho da fonte (1.0 a 2.0)
 * @param enableVoiceNavigation Se a navegação por voz está ativada
 * @param enableVibration Se a vibração está ativada
 * @param enableScreenReader Se a compatibilidade com leitor de tela está ativada
 *
 * @author VisionFit Team
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val email: String,
    val name: String,
    val profileImageUrl: String? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isAdmin: Boolean = false,
    // Configurações de acessibilidade
    val textSizeMultiplier: Float = 1.0f,
    val enableVoiceNavigation: Boolean = true,
    val enableVibration: Boolean = true,
    val enableScreenReader: Boolean = true
)