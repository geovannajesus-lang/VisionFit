package com.visionfit.app.data.local.dao

import androidx.room.*
import com.visionfit.app.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * UserDao - Data Access Object para operações com usuários
 *
 * Fornece métodos para CRUD e consultas relacionadas a usuários.
 *
 * @author VisionFit Team
 */
@Dao
interface UserDao {

    /**
     * Insere um novo usuário no banco de dados
     *
     * @param user Entidade do usuário a ser inserida
     */
    @Insert
    suspend fun insertUser(user: UserEntity)

    /**
     * Atualiza os dados de um usuário existente
     *
     * @param user Entidade do usuário a ser atualizada
     */
    @Update
    suspend fun updateUser(user: UserEntity)

    /**
     * Obtém um usuário pelo ID
     *
     * @param userId ID do usuário
     * @return Flow com os dados do usuário ou null
     */
    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: String): Flow<UserEntity?>

    /**
     * Obtém um usuário pelo email
     *
     * @param email Email do usuário
     * @return Flow com os dados do usuário ou null
     */
    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserByEmail(email: String): Flow<UserEntity?>

    /**
     * Deleta um usuário
     *
     * @param userId ID do usuário a ser deletado
     */
    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteUser(userId: String)

    /**
     * Verifica se um usuário existe
     *
     * @param userId ID do usuário
     * @return true se existe, false caso contrário
     */
    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE id = :userId)")
    suspend fun userExists(userId: String): Boolean
}