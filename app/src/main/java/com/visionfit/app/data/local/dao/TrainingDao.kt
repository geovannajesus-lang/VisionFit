package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.TrainingEntity
import kotlinx.coroutines.flow.Flow

/**
 * TrainingDao - Data Access Object para operações com treinos
 *
 * Fornece métodos para CRUD e consultas relacionadas ao histórico de treinos.
 *
 * @author VisionFit Team
 */
@Dao
interface TrainingDao {

    /**
     * Insere um novo registro de treino
     *
     * @param training Entidade do treino a ser inserido
     */
    @Insert
    suspend fun insertTraining(training: TrainingEntity)

    /**
     * Atualiza um registro de treino
     *
     * @param training Entidade do treino a ser atualizado
     */
    @Update
    suspend fun updateTraining(training: TrainingEntity)

    /**
     * Obtém um treino pelo ID
     *
     * @param trainingId ID do treino
     * @return Flow com os dados do treino ou null
     */
    @Query("SELECT * FROM trainings WHERE id = :trainingId")
    fun getTrainingById(trainingId: String): Flow<TrainingEntity?>

    /**
     * Obtém histórico de treinos de um usuário
     *
     * @param userId ID do usuário
     * @return Flow com lista de treinos ordenada por data (mais recentes primeiro)
     */
    @Query("SELECT * FROM trainings WHERE userId = :userId ORDER BY startTime DESC")
    fun getTrainingsByUser(userId: String): Flow<List<TrainingEntity>>

    /**
     * Obtém treinos de um usuário em uma academia específica
     *
     * @param userId ID do usuário
     * @param gymId ID da academia
     * @return Flow com lista de treinos filtrados
     */
    @Query("SELECT * FROM trainings WHERE userId = :userId AND gymId = :gymId ORDER BY startTime DESC")
    fun getTrainingsByUserAndGym(userId: String, gymId: String): Flow<List<TrainingEntity>>

    /**
     * Obtém treinos recentes (últimos 7 dias)
     *
     * @param userId ID do usuário
     * @param sevenDaysAgo Timestamp de 7 dias atrás
     * @return Flow com lista de treinos recentes
     */
    @Query("SELECT * FROM trainings WHERE userId = :userId AND startTime >= :sevenDaysAgo ORDER BY startTime DESC")
    fun getRecentTrainings(userId: String, sevenDaysAgo: Long): Flow<List<TrainingEntity>>

    /**
     * Deleta um treino
     *
     * @param trainingId ID do treino a ser deletado
     */
    @Query("DELETE FROM trainings WHERE id = :trainingId")
    suspend fun deleteTraining(trainingId: String)
}