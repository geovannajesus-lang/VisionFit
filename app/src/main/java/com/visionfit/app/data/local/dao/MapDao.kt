package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.MapEntity
import kotlinx.coroutines.flow.Flow

/**
 * MapDao - Data Access Object para operações com mapas
 *
 * Fornece métodos para CRUD e consultas relacionadas a mapas de academias.
 *
 * @author VisionFit Team
 */
@Dao
interface MapDao {

    /**
     * Insere um novo mapa
     *
     * @param map Entidade do mapa a ser inserido
     */
    @Insert
    suspend fun insertMap(map: MapEntity)

    /**
     * Atualiza os dados de um mapa
     *
     * @param map Entidade do mapa a ser atualizado
     */
    @Update
    suspend fun updateMap(map: MapEntity)

    /**
     * Obtém um mapa pelo ID
     *
     * @param mapId ID do mapa
     * @return Flow com os dados do mapa ou null
     */
    @Query("SELECT * FROM maps WHERE id = :mapId")
    fun getMapById(mapId: String): Flow<MapEntity?>

    /**
     * Obtém mapa de uma academia em um andar específico
     *
     * @param gymId ID da academia
     * @param floor Número do andar
     * @return Flow com dados do mapa ou null
     */
    @Query("SELECT * FROM maps WHERE gymId = :gymId AND floor = :floor LIMIT 1")
    fun getMapByGymAndFloor(gymId: String, floor: Int): Flow<MapEntity?>

    /**
     * Obtém todos os mapas de uma academia
     *
     * @param gymId ID da academia
     * @return Flow com lista de mapas
     */
    @Query("SELECT * FROM maps WHERE gymId = :gymId ORDER BY floor ASC")
    fun getMapsByGym(gymId: String): Flow<List<MapEntity>>

    /**
     * Deleta um mapa
     *
     * @param mapId ID do mapa a ser deletado
     */
    @Query("DELETE FROM maps WHERE id = :mapId")
    suspend fun deleteMap(mapId: String)
}