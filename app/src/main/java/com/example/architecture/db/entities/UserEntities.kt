package com.example.architecture.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0

@Entity
data class UserEntities(
    var id:String?,
    var first_name:String?,
    var last_name:String?,
    var email:String?
){
    @PrimaryKey(autoGenerate = false)
    var userId = CURRENT_USER_ID
}