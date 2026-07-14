package com.visionfit.app.domain.model

import java.util.Date

/**
 * User - Modelo de domínio para usuário
 *
 * Representa um usuário da aplicação com suas informações e preferências.
 *
 * @param id Identificador único do usuário
 * @param email Email do usuário
 * @param name Nome completo
 * @param profileImageUrl URL da foto de perfil
 * @param createdAt Data de criação
 * @param updatedAt Data da última atualização
 * @param isAdmin Se é administrador
 * @param textSizeMultiplier Multiplicador do tamanho da fonte
 * @param enableVoiceNavigation Se navegação por voz está ativada
 * @param enableVibration Se vibração está ativada
 * @param enableScreenReader Se leitor de tela está ativado
 *
 * @author VisionFit Team
 */
data class User(
    val id: String,
    val email: String,
    val name: String,
    val profileImageUrl: String? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isAdmin: Boolean = false,
    val textSizeMultiplier: Float = 1.0f,
    val enableVoiceNavigation: Boolean = true,
    val enableVibration: Boolean = true,
    val enableScreenReader: Boolean = true
)