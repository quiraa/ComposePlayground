package com.quiraadev.m3pagingsource.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BeerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BeerDatabase : RoomDatabase() {
    abstract val dao : BeerDao
}