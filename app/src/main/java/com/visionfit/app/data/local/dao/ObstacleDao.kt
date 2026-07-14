package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.ObstacleEntity
import kotlinx.coroutines.flow.Flow

/**
 * ObstacleDao - Data Access Object para operações com obstáculos
 *
 * Fornece métodos para CRUD e consultas relacionadas a obstáculos.
 *
 * @author VisionFit Team
 */
@Dao
interface ObstacleDao {

    /**
     * Insere um novo obstáculo
     *
     * @param obstacle Entidade do obstáculo a ser inserido
     */
    @Insert
    suspend fun insertObstacle(obstacle: ObstacleEntity)

    /**
     * Atualiza um obstáculo
     *
     * @param obstacle Entidade do obstáculo a ser atualizado
     */
    @Update
    suspend fun updateObstacle(obstacle: ObstacleEntity)

    /**
     * Obtém um obstáculo pelo ID
     *
     * @param obstacleId ID do obstáculo
     * @return Flow com os dados do obstáculo ou null
     */
    @Query("SELECT * FROM obstacles WHERE id = :obstacleId")
    fun getObstacleById(obstacleId: String): Flow<ObstacleEntity?>

    /**
     * Obtém obstáculos ativos de uma academia
     *
     * @param gymId ID da academia
     * @return Flow com lista de obstáculos não resolvidos
     */
    @Query("SELECT * FROM obstacles WHERE gymId = :gymId AND isResolved = 0 ORDER BY severity DESC")
    fun getActiveObstacles(gymId: String): Flow<List<ObstacleEntity>>

    /**
     * Obtém obstáculos em um andar específico
     *
     * @param gymId ID da academia
     * @param floor Número do andar
     * @return Flow com lista de obstáculos do andar
     */
    @Query("SELECT * FROM obstacles WHERE gymId = :gymId AND floor = :floor AND isResolved = 0")
    fun getObstaclesByFloor(gymId: String, floor: Int): Flow<List<ObstacleEntity>>

    /**
     * Deleta um obstáculo
     *
     * @param obstacleId ID do obstáculo a ser deletado
     */
    @Query("DELETE FROM obstacles WHERE id = :obstacleId")
    suspend fun deleteObstacle(obstacleId: String)
}