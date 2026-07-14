package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.RouteEntity
import kotlinx.coroutines.flow.Flow

/**
 * RouteDao - Data Access Object para operações com rotas
 *
 * Fornece métodos para CRUD e consultas relacionadas a rotas de navegação.
 *
 * @author VisionFit Team
 */
@Dao
interface RouteDao {

    /**
     * Insere uma nova rota
     *
     * @param route Entidade da rota a ser inserida
     */
    @Insert
    suspend fun insertRoute(route: RouteEntity)

    /**
     * Atualiza os dados de uma rota
     *
     * @param route Entidade da rota a ser atualizada
     */
    @Update
    suspend fun updateRoute(route: RouteEntity)

    /**
     * Obtém uma rota pelo ID
     *
     * @param routeId ID da rota
     * @return Flow com os dados da rota ou null
     */
    @Query("SELECT * FROM routes WHERE id = :routeId")
    fun getRouteById(routeId: String): Flow<RouteEntity?>

    /**
     * Obtém rotas associadas a um treino
     *
     * @param trainingId ID do treino
     * @return Flow com lista de rotas
     */
    @Query("SELECT * FROM routes WHERE trainingId = :trainingId")
    fun getRoutesByTraining(trainingId: String): Flow<List<RouteEntity>>

    /**
     * Obtém rotas não completadas
     *
     * @return Flow com lista de rotas ativas
     */
    @Query("SELECT * FROM routes WHERE isCompleted = 0")
    fun getActiveRoutes(): Flow<List<RouteEntity>>

    /**
     * Deleta uma rota
     *
     * @param routeId ID da rota a ser deletada
     */
    @Query("DELETE FROM routes WHERE id = :routeId")
    suspend fun deleteRoute(routeId: String)
}