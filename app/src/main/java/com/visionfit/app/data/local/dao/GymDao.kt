package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.GymEntity
import kotlinx.coroutines.flow.Flow

/**
 * GymDao - Data Access Object para operações com academias
 *
 * Fornece métodos para CRUD e consultas relacionadas a academias.
 *
 * @author VisionFit Team
 */
@Dao
interface GymDao {

    /**
     * Insere uma nova academia
     *
     * @param gym Entidade da academia a ser inserida
     */
    @Insert
    suspend fun insertGym(gym: GymEntity)

    /**
     * Atualiza os dados de uma academia
     *
     * @param gym Entidade da academia a ser atualizada
     */
    @Update
    suspend fun updateGym(gym: GymEntity)

    /**
     * Obtém uma academia pelo ID
     *
     * @param gymId ID da academia
     * @return Flow com os dados da academia ou null
     */
    @Query("SELECT * FROM gyms WHERE id = :gymId")
    fun getGymById(gymId: String): Flow<GymEntity?>

    /**
     * Obtém todas as academias ativas
     *
     * @return Flow com lista de academias ativas
     */
    @Query("SELECT * FROM gyms WHERE isActive = 1 ORDER BY name ASC")
    fun getAllActiveGyms(): Flow<List<GymEntity>>

    /**
     * Obtém academias por administrador
     *
     * @param adminId ID do administrador
     * @return Flow com lista de academias do administrador
     */
    @Query("SELECT * FROM gyms WHERE adminId = :adminId ORDER BY name ASC")
    fun getGymsByAdmin(adminId: String): Flow<List<GymEntity>>

    /**
     * Deleta uma academia
     *
     * @param gymId ID da academia a ser deletada
     */
    @Query("DELETE FROM gyms WHERE id = :gymId")
    suspend fun deleteGym(gymId: String)
}