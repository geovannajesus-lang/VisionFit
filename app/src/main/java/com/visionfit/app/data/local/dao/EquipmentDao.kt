package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.EquipmentEntity
import kotlinx.coroutines.flow.Flow

/**
 * EquipmentDao - Data Access Object para operações com equipamentos
 *
 * Fornece métodos para CRUD e consultas relacionadas a equipamentos.
 *
 * @author VisionFit Team
 */
@Dao
interface EquipmentDao {

    /**
     * Insere um novo equipamento
     *
     * @param equipment Entidade do equipamento a ser inserido
     */
    @Insert
    suspend fun insertEquipment(equipment: EquipmentEntity)

    /**
     * Atualiza os dados de um equipamento
     *
     * @param equipment Entidade do equipamento a ser atualizado
     */
    @Update
    suspend fun updateEquipment(equipment: EquipmentEntity)

    /**
     * Obtém um equipamento pelo ID
     *
     * @param equipmentId ID do equipamento
     * @return Flow com os dados do equipamento ou null
     */
    @Query("SELECT * FROM equipments WHERE id = :equipmentId")
    fun getEquipmentById(equipmentId: String): Flow<EquipmentEntity?>

    /**
     * Obtém todos os equipamentos de uma academia
     *
     * @param gymId ID da academia
     * @return Flow com lista de equipamentos
     */
    @Query("SELECT * FROM equipments WHERE gymId = :gymId AND isActive = 1 ORDER BY name ASC")
    fun getEquipmentsByGym(gymId: String): Flow<List<EquipmentEntity>>

    /**
     * Obtém equipamentos por categoria
     *
     * @param gymId ID da academia
     * @param category Categoria do equipamento
     * @return Flow com lista de equipamentos da categoria
     */
    @Query("SELECT * FROM equipments WHERE gymId = :gymId AND category = :category AND isActive = 1 ORDER BY name ASC")
    fun getEquipmentsByCategory(gymId: String, category: String): Flow<List<EquipmentEntity>>

    /**
     * Deleta um equipamento
     *
     * @param equipmentId ID do equipamento a ser deletado
     */
    @Query("DELETE FROM equipments WHERE id = :equipmentId")
    suspend fun deleteEquipment(equipmentId: String)
}