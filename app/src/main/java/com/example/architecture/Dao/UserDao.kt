package com.example.architecture.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architecture.db.entities.CURRENT_USER_ID
import com.example.architecture.db.entities.UserEntities

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntities: UserEntities):Long

    @Query("SELECT * FROM USERENTITIES WHERE userId = $CURRENT_USER_ID")
    fun getUser(): LiveData<UserEntities>
}